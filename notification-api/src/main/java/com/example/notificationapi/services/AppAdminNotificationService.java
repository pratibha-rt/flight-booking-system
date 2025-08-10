package com.example.notificationapi.services;

import com.example.notificationapi.dto.AirlineRegistrationReqDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@Slf4j
public class AppAdminNotificationService {
    JavaMailSender javaMailSender;
    TemplateEngine templateEngine;

    @Autowired
    public AppAdminNotificationService(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    public void sendAirlineRegistrationRequestNotification
            (AirlineRegistrationReqDto airlineRegistrationReqDto) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

            Context context = getContext(airlineRegistrationReqDto);
            String htmlContent = templateEngine.process("airline-registration-request", context);

            helper.setTo(airlineRegistrationReqDto.getAppAdmin().getEmail());
            helper.setSubject(airlineRegistrationReqDto.getAirline().getAirlineName());
            helper.setText(htmlContent, true);
            javaMailSender.send(mimeMessage );
            System.out.println("mail sent!!");
        } catch (Exception e) {
            log.error("Error sending airline registration notification: {}", e.getMessage());
        }

    }

    private Context getContext(AirlineRegistrationReqDto airlineRegistrationReqDto) {
        Context context = new Context();
        context.setVariable("airlineName", airlineRegistrationReqDto.getAirline().getAirlineName());
        context.setVariable("companyName", airlineRegistrationReqDto.getAirline().getCompanyName());
        context.setVariable("website", airlineRegistrationReqDto.getAirline().getWebsite());
        context.setVariable("employees", airlineRegistrationReqDto.getAirline().getEmployees());
        context.setVariable("totalFlights", airlineRegistrationReqDto.getAirline().getTotalFlights());
        context.setVariable("airlineAdminName", airlineRegistrationReqDto.getAirline().getAdmin().getName());
        context.setVariable("adminEmail", airlineRegistrationReqDto.getAirline().getAdmin().getEmail());
        context.setVariable("requestedTime", airlineRegistrationReqDto.getAirline().getCreatedAt().toString());
        context.setVariable("acceptLink", "http://localhost:8082/api/v1/central/airline/request/accept/" + airlineRegistrationReqDto.getAirline().getId().toString());
        return context;
    }
}
