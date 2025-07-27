package com.example.centralapi.utility;

import com.example.centralapi.dto.AirlineRegistrationDto;
import com.example.centralapi.enums.AirlineStatus;
import com.example.centralapi.enums.UserStatus;
import com.example.centralapi.enums.UserType;
import com.example.centralapi.models.Airline;
import com.example.centralapi.models.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Slf4j
@Component
public class Mapper {

    public AppUser mapAirlineResgistrationDtoToAppUser (AirlineRegistrationDto airlineDetails) {
        AppUser airlineAdmin = new AppUser();

        airlineAdmin.setEmail(airlineDetails.getEmail());
        airlineAdmin.setName(airlineDetails.getAirlineName() + " Admin");
        airlineAdmin.setUserType(UserType.AIRLINE_ADMIN.toString());
        airlineAdmin.setNumber(airlineDetails.getContactNumber());
        airlineAdmin.setVerified(false);
        airlineAdmin.setStatus(UserStatus.INACTIVE.toString());
        airlineAdmin.setPassword(airlineDetails.getPassword());
        airlineAdmin.setCreatedAt(LocalDateTime.now());
        airlineAdmin.setUpdatedAt(LocalDateTime.now());
        log.info("Email received: {}", airlineAdmin);
        return airlineAdmin;
    }

    public Airline mapAirlineRegistrationDtoToAirline (AirlineRegistrationDto airlineDetails, AppUser admin) {
        Airline airline = new Airline();
        airline.setAirlineName(airlineDetails.getAirlineName());
        airline.setStatus(AirlineStatus.INACTIVE.toString());
        airline.setCreatedAt(LocalDateTime.now());
        airline.setUpdatedAt(LocalDateTime.now());
        airline.setAdmin(admin);
        airline.setEmployees(airlineDetails.getEmployees());
        airline.setCompanyName(airlineDetails.getCompanyName());
        airline.setTotalFlights(airlineDetails.getTotalFlights());
        airline.setWebsite(airlineDetails.getWebsite());
        return airline;
    }

}
