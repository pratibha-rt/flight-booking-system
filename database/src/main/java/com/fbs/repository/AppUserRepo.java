package com.fbs.repository;

import com.fbs.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, UUID> {
    AppUser findByEmail (String email);
    List<AppUser> findByUserType(String userType);
}
