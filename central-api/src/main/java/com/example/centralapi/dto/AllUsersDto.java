package com.example.centralapi.dto;

import com.example.centralapi.models.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllUsersDto {
    List<AppUser> appUsers;
}