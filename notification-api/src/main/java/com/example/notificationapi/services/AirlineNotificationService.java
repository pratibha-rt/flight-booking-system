package com.example.notificationapi.services;

import com.example.notificationapi.dto.AirlineRejectDto;
import com.example.notificationapi.models.Airline;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Slf4j
@Service
public class AirlineNotificationService {
    JavaMailSender javaMailSender;
    TemplateEngine templateEngine;

    @Autowired
    public AirlineNotificationService(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    public void airlineAcceptNotification (Airline airline) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

            Context context = new Context();
            context.setVariable("airlineAdminName", airline.getAdmin().getName());
            context.setVariable("airlineName", airline.getAirlineName());
            context.setVariable("companyName", airline.getCompanyName());
            context.setVariable("website", airline.getWebsite());
            context.setVariable("totalFlights", airline.getTotalFlights());
            context.setVariable("employees", airline.getEmployees());
            context.setVariable("activatedAt", airline.getUpdatedAt());
            String htmlContent = templateEngine.process("airline-registration-request-accepted", context);

            helper.setTo(airline.getAdmin().getEmail());
            helper.setSubject("Airline Registration Request Accepted");
            helper.setText(htmlContent, true);
            javaMailSender.send(mimeMessage);
        } catch(Exception e) {
            log.error(e.getMessage());
        }
    }

    public void airlineAdminRejectNotification(AirlineRejectDto airlineRejectDto) {

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

            Context context = new Context();
            context.setVariable("adminName", airlineRejectDto.getAirlineAdminName());
            context.setVariable("reason", airlineRejectDto.getRejectReason());
            String htmlContent = templateEngine.process("reject-airline-dto", context);
            helper.setTo(airlineRejectDto.getAirlineAdminEmail());
            helper.setSubject("Registration Request Rejected");
            helper.setText(htmlContent, true);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}













