package com.stratosphere.account.service;

import com.stratosphere.account.dto.AccountGeneratedCommand;
import com.stratosphere.account.dto.CreateAccountCommand;
import com.stratosphere.account.exceptions.AccountExistException;
import com.stratosphere.account.exceptions.EmailNotValidException;
import com.stratosphere.account.exceptions.PasswordNotValidException;

public interface CreateAccount {
    public AccountGeneratedCommand invoke(CreateAccountCommand cmd) throws EmailNotValidException, PasswordNotValidException, AccountExistException;
}
