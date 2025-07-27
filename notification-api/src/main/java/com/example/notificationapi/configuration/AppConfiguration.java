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
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("accioshoppingwebsite@gmail.com");
        javaMailSender.setPassword("qwertyuiop");
        Properties props = javaMailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        return javaMailSender;
    }

    @Bean
    public TemplateEngine getThymeleafBean() {
        return new TemplateEngine();
    }
}
