package com.fbs.repository;

import com.fbs.models.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AirlineRepo extends JpaRepository<Airline, UUID> {
}
