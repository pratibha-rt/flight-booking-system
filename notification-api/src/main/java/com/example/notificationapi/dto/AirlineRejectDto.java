package com.example.notificationapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirlineRejectDto {
    String airlineAdminEmail;
    String airlineAdminName;
    String rejectReason;
}
