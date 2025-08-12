package com.example.notificationapi.configuration;

import jakarta.mail.internet.MimeMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.Thymeleaf;

import java.io.InputStream;
import java.util.Properties;

@Configuration
public class AppConfiguration {

    @Bean
    public JavaMailSender javaMailSender () {
        return new JavaMailSenderImpl();
    }

    @Bean
    public TemplateEngine getThymeleafBean() {
        return new TemplateEngine();
    }
}
