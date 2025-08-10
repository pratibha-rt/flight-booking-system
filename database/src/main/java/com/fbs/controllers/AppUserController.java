package com.fbs.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fbs.dto.AllUsersDto;
import com.fbs.models.AppUser;
import com.fbs.repository.AppUserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/db/appuser")
public class AppUserController {
    AppUserRepo appUserRepo;
    @Autowired
    public AppUserController (AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @GetMapping(value = "/get/{userType}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AllUsersDto> getAllUsers (@PathVariable String userType) throws JsonProcessingException {
        List<AppUser> appUserList = appUserRepo.findByUserType(userType);
        AllUsersDto allUsersDto = new AllUsersDto();
        allUsersDto.setAppUsers(appUserList);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        System.out.println(mapper.writeValueAsString(allUsersDto));

        return new ResponseEntity<>(allUsersDto, HttpStatus.OK);
    }
//    @GetMapping("/get/{userType}")
//    public ResponseEntity getAllUsersByUserType(@PathVariable String userType){
//        List<AppUser> users = appUserRepo.findByUserType(userType);
//        AllUsersDto allUsersDto = new AllUsersDto();
//        allUsersDto.setAppUsers(users);
//        return new ResponseEntity(allUsersDto, HttpStatus.OK);
//    }
    @GetMapping("/{id}")
    public ResponseEntity getAppUser (@PathVariable UUID id) {
        return new ResponseEntity<> (appUserRepo.findById(id), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity getAppUserByEmail (@PathVariable String email) {
        return new ResponseEntity<>(appUserRepo.findByEmail(email), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<AppUser> createAppUser (@RequestBody AppUser appUser) {
        System.out.println("Creating AppUser: " + appUser.getEmail() + " with name: " + appUser.getName());
        AppUser user = appUserRepo.save(appUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AppUser> updateUser (@RequestBody AppUser appUser) {
        return new ResponseEntity<>(appUserRepo.save(appUser), HttpStatus.OK);
    }
}
