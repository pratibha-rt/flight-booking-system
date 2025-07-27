package com.fbs.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="airlines")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @Column(unique = true, nullable = false)
    String website;
    @Column(unique = true, nullable = false)
    String airlineName;
    @Column(unique = true, nullable = false)
    String companyName;
    int employees;
    int totalFlights;
    String status;
    @OneToOne
    AppUser admin;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

}
