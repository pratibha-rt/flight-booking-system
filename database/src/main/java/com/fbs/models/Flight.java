package com.fbs.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @ManyToOne
    Airline airline;
    @ManyToOne
    Aircraft aircraft;
    String sourceAirportl;
    String destinationAirport;
    String flightType;
    int totalTime;
    LocalDateTime boardingTime;
    LocalDateTime departureTime;
    LocalDateTime arrivalTime;
    int boardingMinutes;
    boolean isConnecting;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

}
