package com.stratosphere.account.singup.mother;

import com.stratosphere.account.domain.Account;
import com.stratosphere.account.domain.Phone;
import com.stratosphere.account.dto.CreateAccountCommand;

import java.util.*;

public class AccountMother {

    public static Account generateAccount() {
        Account account = new Account();
        account.setId(UUID.randomUUID().toString());
        account.setCreated(new Date());
        account.setEmail("asfzxd@asd.com");
        account.setName("ddf");
        account.setPassword("asd1dAr8");
        account.setPhones(new HashSet<>());
        return account;
    }

    public static CreateAccountCommand generate() {
        CreateAccountCommand genereted = new CreateAccountCommand();
        genereted.setEmail("asfzxd@asd.com");
        genereted.setName("ddf");
        genereted.setPassword("asd1dAr8");
        genereted.setPhones(new ArrayList<>());
        return genereted;
    }

    public static CreateAccountCommand generateDuplicate() {
        CreateAccountCommand genereted = new CreateAccountCommand();
        genereted.setEmail("asd@asd.com");
        genereted.setName("dd");
        genereted.setPassword("asd1dAr8");
        genereted.setPhones(new ArrayList<>());
        return genereted;
    }

    public static CreateAccountCommand generateExceptionEmail() {
        CreateAccountCommand genereted = new CreateAccountCommand();
        genereted.setEmail("asd");
        genereted.setName("dd");
        genereted.setPassword("asd1dAr8");
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
