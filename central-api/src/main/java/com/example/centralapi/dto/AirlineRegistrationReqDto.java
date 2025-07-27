package com.example.centralapi.dto;


import com.example.centralapi.models.Airline;
import com.example.centralapi.models.AppUser;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AirlineRegistrationReqDto {
    AppUser appAdmin;
    Airline airline;
}
