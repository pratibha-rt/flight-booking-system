package com.fbs.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "flightseatmappings")
public class FlightSeatMapping extends SeatMapping{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    @ManyToOne
    Flight flight;
}
















