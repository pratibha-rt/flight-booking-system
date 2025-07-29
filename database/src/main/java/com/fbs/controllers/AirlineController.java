package com.fbs.controllers;

import com.fbs.models.Airline;
import com.fbs.repository.AirlineRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/db/airline")
public class AirlineController {

    AirlineRepo airlineRepo;
    @Autowired
    public AirlineController(AirlineRepo airlineRepo) {
        this.airlineRepo = airlineRepo;
    }

    @PostMapping("/create")
    public ResponseEntity<Airline> createAirline(@RequestBody Airline airline) {
        return new ResponseEntity<>(airlineRepo.save(airline), HttpStatus.CREATED);
    }

    @GetMapping("/{airlineId}")
    public ResponseEntity readAirline(@PathVariable UUID airlineId) {
        return new ResponseEntity<>(airlineRepo.findById(airlineId), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Airline> updateAirline (@RequestBody Airline airline) {
        return new ResponseEntity<>(airlineRepo.save(airline), HttpStatus.OK);
    }

    @GetMapping("/get/admin/{adminId}")
    public ResponseEntity getAirlineByAdminId (@PathVariable UUID adminId) {
        return new ResponseEntity<> (airlineRepo.findById(adminId), HttpStatus.OK);
    }
}
