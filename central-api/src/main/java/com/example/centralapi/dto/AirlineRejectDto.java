package com.example.centralapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirlineRejectDto {
    String airlineAdminEmail;
    String airlineAdminName;
    String rejectReason;

}
