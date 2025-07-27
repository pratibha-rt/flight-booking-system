package com.example.notificationapi.dto;

import com.example.notificationapi.models.Airline;
import com.example.notificationapi.models.AppUser;
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
