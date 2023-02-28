package com.stratosphere.account.application;

import java.io.Serializable;
import java.util.List;

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

    public AuthenticatedAccountCommand() {}

    public AuthenticatedAccountCommand(String id, String created, String lastLogin, String token, boolean isActive, String name, String email, String password, List<PhoneCommand> phones) {
        this.id = id;
        this.created = created;
        this.lastLogin = lastLogin;
        this.token = token;
        this.isActive = isActive;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PhoneCommand> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneCommand> phones) {
        this.phones = phones;
    }

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

