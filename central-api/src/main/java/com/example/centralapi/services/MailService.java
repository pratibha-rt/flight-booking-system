package com.example.centralapi.services;

import com.example.centralapi.connectors.NotificationApi;
import com.example.centralapi.dto.AirlineRegistrationDto;
import com.example.centralapi.dto.AirlineRegistrationReqDto;
import com.example.centralapi.models.Airline;
import com.example.centralapi.models.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MailService {
    NotificationApi notificationApi;
    @Autowired
    public MailService(NotificationApi notificationApi) {
        this.notificationApi = notificationApi;
    }

    public void mailSystemAdminForAirlineRegistration(List<AppUser> systemAdmin, Airline airline) {
        for (AppUser user : systemAdmin) {
            AirlineRegistrationReqDto airlineRegistrationReqDto = new AirlineRegistrationReqDto();
            airlineRegistrationReqDto.setAirline(airline);
            airlineRegistrationReqDto.setAppAdmin(user);
            notificationApi.notifySystemAdminForAirlineRegistration(airlineRegistrationReqDto);
            System.out.println("mail send!!");

        }
    }

    public void notifyAcceptToAirlineAdmin (Airline airline) {
        try {
            notificationApi.notifyAcceptRequestToAirlineAdmin(airline);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
