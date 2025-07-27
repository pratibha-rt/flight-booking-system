package com.example.centralapi.contollers;

import com.example.centralapi.dto.AirlineRegistrationDto;
import com.example.centralapi.services.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/central/airline")
public class Airline {

    AirlineService airlineService;
    @Autowired
    public Airline(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @PostMapping("/register")
    public ResponseEntity registerAirline(
            @RequestBody AirlineRegistrationDto airlineRegistrationDto) {
        com.example.centralapi.models.Airline airline = airlineService.registerAirline(airlineRegistrationDto);
        return  new ResponseEntity<>(airline, HttpStatus.CREATED);
    }
}
