package com.fbs.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "subflightseatmappings")
public class SubFlightSeatMapping extends SeatMapping{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @ManyToOne
    SubFlight flight;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

}
