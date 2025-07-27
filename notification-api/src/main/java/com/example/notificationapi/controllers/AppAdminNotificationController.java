package com.example.notificationapi.controllers;

import com.example.notificationapi.dto.AirlineRegistrationReqDto;
import com.example.notificationapi.services.AppAdminNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notifications/appAdmin")
public class AppAdminNotificationController {
    AppAdminNotificationService appAdminNotificationService;

    @Autowired
    public AppAdminNotificationController(AppAdminNotificationService appAdminNotificationService) {
        this.appAdminNotificationService = appAdminNotificationService;
    }

    @PutMapping("/airline-registration")
    public void airlineRegistrationRequestNotification
            (@RequestBody AirlineRegistrationReqDto airlineRegistrationReqDto) {
        appAdminNotificationService.sendAirlineRegistrationRequestNotification(airlineRegistrationReqDto);

    }
}
