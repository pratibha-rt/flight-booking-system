package com.fbs.controllers;

import com.fbs.dto.AllUsersDto;
import com.fbs.models.AppUser;
import com.fbs.repository.AppUserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/get/{userType}")
    public ResponseEntity getAllUsers (@PathVariable String userType) {
        List<AppUser> appUserList = appUserRepo.findByUserType(userType);
        AllUsersDto allUsersDto = new AllUsersDto();
        allUsersDto.setAppUsers(appUserList);
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
        AppUser user = appUserRepo.save(appUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
