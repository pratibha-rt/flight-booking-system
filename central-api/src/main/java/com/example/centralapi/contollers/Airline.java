package com.example.centralapi.contollers;

import com.example.centralapi.dto.AirlineRegistrationDto;
import com.example.centralapi.services.AirlineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@Slf4j
@RestController
@RequestMapping("/api/v1/central/airline")
public class Airline {

    AirlineService airlineService;
    @Autowired
    public Airline(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @PostMapping( value = "/register" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<com.example.centralapi.models.Airline> registerAirline(
            @RequestBody AirlineRegistrationDto airlineRegistrationDto) {
        com.example.centralapi.models.Airline airline = airlineService.registerAirline(airlineRegistrationDto);
        System.out.println("Airline registered: " + airline.getAirlineName() + " with ID: " + airline.getId());
        return  new ResponseEntity<>(airline, HttpStatus.CREATED);
    }

    @GetMapping("/request/accept/{airlineId}")
    public void acceptAirlineRequest(@PathVariable UUID airlineId) {
        log.info("airline Id : " + airlineId.toString());
        airlineService.acceptAirlineRequest(airlineId);
    }

}
