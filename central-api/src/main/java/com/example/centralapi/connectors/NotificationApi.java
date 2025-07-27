package com.example.centralapi.connectors;

import com.example.centralapi.dto.AirlineRegistrationReqDto;
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
        RequestEntity request = RequestEntity.get(url).build();
        restTemplate.exchange(url, HttpMethod.GET, request, Object.class);
    }


}
