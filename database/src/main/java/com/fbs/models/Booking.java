package com.fbs.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

@Data
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @ManyToOne
    Flight flight;
    @ManyToMany
    List<SubFlight> subFlights;
    @ManyToOne
    AppUser bookedBy;
    int totalAmount;
    String passengerName;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

}
