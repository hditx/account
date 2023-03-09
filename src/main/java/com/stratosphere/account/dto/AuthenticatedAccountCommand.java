package com.stratosphere.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

import java.io.Serializable;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Log
public class AuthenticatedAccountCommand implements Serializable {
    private String id;
    private String created;
    private String lastLogin;
    private String token;
    private boolean isActive;
    private String name;
    private String email;
    private String password;
    private List<PhoneCommand> phones;

    @Override
    public String toString() {
        return "{" +
                "\"id\": \"" + id + "\"" +
                ", \"created\": \"" + created + "\"" +
                ", \"lastLogin\": \"" + lastLogin + "\"" +
                ", \"token\": \"" + token + "\"" +
                ", \"isActive\": " + isActive +
                ", \"name\": \"" + name + "\"" +
                ", \"email\": \"" + email + "\"" +
                ", \"password\": \"" + password + "\"" +
                ", \"phones\": " + phones +
                '}';
    }
}

