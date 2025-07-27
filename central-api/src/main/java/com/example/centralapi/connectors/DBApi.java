package com.example.centralapi.connectors;

import com.example.centralapi.dto.AllUsersDto;
import com.example.centralapi.models.Airline;
import com.example.centralapi.models.AppUser;
import com.sun.javaws.progress.PreloaderDelegate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class DBApi {

    RestTemplate restTemplate;

    public DBApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Value("${database.url}")
    String dbApiBaseUrl;

    public AppUser callCreateUserEndpoint (AppUser appuser) {
        String url = dbApiBaseUrl + "/appuser/create";
        RequestEntity request = RequestEntity.post(url).body(appuser);
        ResponseEntity<AppUser> response = restTemplate.exchange(url, HttpMethod.POST, request, AppUser.class);
        return response.getBody();
    }

    public Airline callCreateAirlineEndpoint (Airline airline) {
        String url = dbApiBaseUrl + "/airline/create";
        RequestEntity request = RequestEntity.post(url).body(airline);
        ResponseEntity<Airline> response = restTemplate.exchange(url, HttpMethod.POST, request, Airline.class);
        return response.getBody();

    }

    public List<AppUser> callGetAllSystemUserEndpoints (String userType) {
        String url = dbApiBaseUrl + "/appuser/get/" + userType;
        RequestEntity request = RequestEntity.get(url).build();
        ResponseEntity<AllUsersDto> response = restTemplate.exchange(url, HttpMethod.GET, request, AllUsersDto.class);
        return response.getBody().getAppUsers();

    }
}


















