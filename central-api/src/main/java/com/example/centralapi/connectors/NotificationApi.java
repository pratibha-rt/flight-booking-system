package com.example.centralapi.connectors;

import com.example.centralapi.dto.AirlineRegistrationDto;
import com.example.centralapi.dto.AirlineRegistrationReqDto;
import com.example.centralapi.dto.AirlineRejectDto;
import com.example.centralapi.models.Airline;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NotificationApi {

    RestTemplate restTemplate;

    public NotificationApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${notification.api.url}")
    String baseUrl;

    public void notifySystemAdminForAirlineRegistration(AirlineRegistrationReqDto airlineRegistrationReqDto) {
        String url = baseUrl + "/appAdmin/airline-registration";
        RequestEntity request = RequestEntity.put(url).body(airlineRegistrationReqDto);
        restTemplate.exchange(url, HttpMethod.PUT, request, Object.class);
    }

    public void notifyAcceptRequestToAirlineAdmin(Airline airline) {
        String url = baseUrl + "/airline/admin/accept-request";
        RequestEntity request = RequestEntity.put(url).body(airline);
        restTemplate.exchange(url, HttpMethod.PUT, request, Object.class);
    }

    public void notifyRejectToAirlineAdmin (AirlineRejectDto airlineRejectDto) {
        String url = baseUrl + "/airline/admin/reject-request";
        RequestEntity request = RequestEntity.put(url).body(airlineRejectDto);
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.PUT, request, Object.class);
    }

}
