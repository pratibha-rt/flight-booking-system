package com.fbs.dto;

import com.fbs.models.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllUsersDto {
    List<AppUser> appUsers;

    public void setAppUsers(List<AppUser> appUsers) {
        this.appUsers = appUsers;
    }
}
