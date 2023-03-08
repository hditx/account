package com.stratosphere.account.dto;

import java.util.List;

public final class CreateAccountCommand {

    private String name;
    private String email;
    private String password;
    private List<CreateAccountPhoneCommand> phones;
    public CreateAccountCommand() {}
    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<CreateAccountPhoneCommand> getPhones() {
        return phones;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhones(List<CreateAccountPhoneCommand> phones) {
        this.phones = phones;
    }
}
