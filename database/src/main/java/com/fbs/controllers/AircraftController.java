package com.fbs.controllers;

import com.fbs.models.Aircraft;
import com.fbs.repository.AircraftRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/aircraft")
public class AircraftController {
    AircraftRepo aircraftRepo;
    @Autowired
    public AircraftController (AircraftRepo aircraftRepo) {
        this.aircraftRepo = aircraftRepo;
    }

    @GetMapping("/{id}")
    public ResponseEntity getAircraft (@PathVariable UUID id) {
        return new ResponseEntity<>(aircraftRepo.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Aircraft> createAircraft (@RequestBody Aircraft aircraft) {
        return new ResponseEntity<>(aircraftRepo.save(aircraft), HttpStatus.CREATED);
    }

}
