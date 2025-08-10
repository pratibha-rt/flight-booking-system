package com.example.notificationapi.controllers;

import com.example.notificationapi.models.Airline;
import com.example.notificationapi.services.AirlineNotificationService;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notifications/airline")
public class AirlineNotification {
    AirlineNotificationService airlineNotificationService;

    public AirlineNotification(AirlineNotificationService airlineNotificationService) {
        this.airlineNotificationService = airlineNotificationService;
    }

    @PutMapping("/admin/accept-request")
    public void airlineAdminAcceptNotification(@RequestBody Airline airline) {
        airlineNotificationService.airlineAcceptNotification(airline);
    }
}
