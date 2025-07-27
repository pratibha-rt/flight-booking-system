package com.fbs.repository;

import com.fbs.models.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AircraftRepo extends JpaRepository<Aircraft, UUID> {

}
