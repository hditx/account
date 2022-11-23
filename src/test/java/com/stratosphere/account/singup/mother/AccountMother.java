package com.stratosphere.account.singup.mother;

import com.stratosphere.account.application.CreateAccountCommand;

import java.util.ArrayList;

public class AccountMother {

    public static CreateAccountCommand generate() {
        CreateAccountCommand genereted = new CreateAccountCommand();
        genereted.setEmail("asd@asd.com");
        genereted.setName("dd");
        genereted.setPassword("aaaaa21A");
        genereted.setPhones(new ArrayList<>());
        return genereted;
    }

    public static CreateAccountCommand generateExceptionEmail() {
        CreateAccountCommand genereted = new CreateAccountCommand();
        genereted.setEmail("asd");
        genereted.setName("dd");
        genereted.setPassword("aaaaa21A");
        genereted.setPhones(new ArrayList<>());
        return genereted;
    }

    public static CreateAccountCommand generateExceptionPassword() {
        CreateAccountCommand genereted = new CreateAccountCommand();
        genereted.setEmail("asd@asd.com");
        genereted.setName("dd");
        genereted.setPassword("asdddd");
        genereted.setPhones(new ArrayList<>());
        return genereted;
    }
}
