package com.fbs.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "subflights")
public class SubFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @ManyToOne
    Flight flight;
    int priority;
    String sourceAirport;
    String destinationAirport;
    LocalDateTime arrivalTime;
    LocalDateTime departureTime;
    LocalDateTime boardingTime;
    int boardingMinutes;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
