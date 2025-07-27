package com.fbs.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "aircrafts")
public class Aircraft {
    // id	AircraftName	ModelNumber
    // developerCompany	planeModel	totalFlighs	buildDate	airlineId	capacity
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String  modelName;
    int modelNumber;
    String manufacturer;
    int totalFlights;
    LocalDate buildDate;
    int capacity;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
