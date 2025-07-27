package com.example.centralapi.services;

import com.example.centralapi.connectors.DBApi;
import com.example.centralapi.enums.UserType;
import com.example.centralapi.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    DBApi dbApi;

    @Autowired
    public UserService(DBApi dbApi) {
        this.dbApi = dbApi;
    }

    public List<AppUser> listOfAllUserAdmin () {
        return dbApi.callGetAllSystemUserEndpoints(UserType.SYSTEM_ADMIN.toString());
    }
}
