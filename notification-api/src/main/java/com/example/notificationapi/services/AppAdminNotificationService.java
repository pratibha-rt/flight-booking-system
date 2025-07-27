package com.example.notificationapi.services;

import com.example.notificationapi.dto.AirlineRegistrationReqDto;
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
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        Context context = new Context();
        context.setVariable("airlineName",airlineRegistrationReqDto.getAirline().getAirlineName());
        context.setVariable("companyName", airlineRegistrationReqDto.getAirline().getCompanyName());
        context.setVariable("website", airlineRegistrationReqDto.getAirline().getWebsite());
        context.setVariable("employees", airlineRegistrationReqDto.getAirline().getEmployees());
        context.setVariable("totalFlights", airlineRegistrationReqDto.getAirline().getTotalFlights());
        context.setVariable("airlineAdminName", airlineRegistrationReqDto.getAirline().getAdmin().getName());
        context.setVariable("adminEmail", airlineRegistrationReqDto.getAirline().getAdmin().getEmail());
        context.setVariable("requestedTime", airlineRegistrationReqDto.getAirline().getCreatedAt().toString());
        String htmlContent = templateEngine.process("airline-resgistration-request", context);
        try{
            mimeMessageHelper.setTo(airlineRegistrationReqDto.getAppAdmin().getEmail());
            mimeMessageHelper.setSubject(airlineRegistrationReqDto.getAirline().getAirlineName());
            mimeMessageHelper.setText(htmlContent, "true");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        javaMailSender.send(mimeMessage );
    }
}
