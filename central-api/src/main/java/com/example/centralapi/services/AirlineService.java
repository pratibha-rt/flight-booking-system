package com.example.centralapi.services;

import com.example.centralapi.connectors.DBApi;
import com.example.centralapi.dto.AirlineRegistrationDto;
import com.example.centralapi.models.Airline;
import com.example.centralapi.models.AppUser;
import com.example.centralapi.utility.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {
    Mapper mapper;
    DBApi dbApiConnector;
    UserService userService;
    MailService mailService;
    @Autowired
    public AirlineService (Mapper mapper, DBApi dbApi, UserService userService, MailService mailService) {
        this.mapper = mapper;
        this.dbApiConnector = dbApi;
        this.userService = userService;
        this.mailService = mailService;
    }

    public Airline registerAirline(AirlineRegistrationDto airlineRegistrationDto) {
        AppUser appUserAdmin = mapper.mapAirlineResgistrationDtoToAppUser(airlineRegistrationDto);
        appUserAdmin = dbApiConnector.callCreateUserEndpoint(appUserAdmin);
        Airline airline = mapper.mapAirlineRegistrationDtoToAirline(airlineRegistrationDto, appUserAdmin);
        airline = dbApiConnector.callCreateAirlineEndpoint(airline);
//        List<AppUser> systemAdminList = userService.listOfAllUserAdmin();
//        mailService.mailSystemAdminForAirlineRegistration(systemAdminList, airline);
        return airline;
    }
}
