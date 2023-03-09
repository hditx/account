package com.stratosphere.account.service.impl;

import com.stratosphere.account.domain.Account;
import com.stratosphere.account.domain.Phone;
import com.stratosphere.account.dto.CreateAccountPhoneCommand;
import com.stratosphere.account.exceptions.AccountExistException;
import com.stratosphere.account.exceptions.EmailNotValidException;
import com.stratosphere.account.exceptions.PasswordNotValidException;
import com.stratosphere.account.dto.AccountGeneratedCommand;
import com.stratosphere.account.dto.CreateAccountCommand;
import com.stratosphere.account.repository.AccountRepository;
import com.stratosphere.account.service.CreateAccount;
import com.stratosphere.account.shared.config.JwtGenerate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CreateAccountImpl implements CreateAccount {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private JwtGenerate generate;

    private final Logger log = LoggerFactory.getLogger(CreateAccountImpl.class);
    @Override
    public AccountGeneratedCommand invoke(CreateAccountCommand cmd) throws EmailNotValidException, PasswordNotValidException, AccountExistException {
        log.info("Init creation new account");
        validateEmail(cmd.getEmail());
        validatePassword(cmd.getPassword());
        validateExistAccount(cmd.getEmail());
        Account account = parseToUser(cmd);
        AccountGeneratedCommand command = parseToAccountGeneratedCommand(repository.save(account));
        log.info("Account create success " + command.getId());
        log.info("Finish creation new account");
        return command;
    }

    private Account parseToUser(CreateAccountCommand cmd) {
        Account account = new Account();
        account.setId(UUID.randomUUID().toString());
        account.setName(cmd.getName());
        account.setEmail(cmd.getEmail());
        account.setCreated(new Date());
        account.setPassword(DigestUtils.md5DigestAsHex(cmd.getPassword().getBytes(StandardCharsets.UTF_8)));
        account.setActive(true);
        account.setPhones(parseToPhone(cmd.getPhones()));
        return account;
    }

    private void validateEmail(String email) throws EmailNotValidException {
        log.info("Validate email formant");
        if (!email.matches("^[a-z]*@([a-z]+\\.)+[a-z]{2,7}"))
            throw new EmailNotValidException();
    }

    private void validatePassword(String password) throws PasswordNotValidException {
        log.info("Validate password format");
        if(!password.matches("(?=.*[0-9].{2})(?=.*[a-z])(?=.*[A-Z].{1}).{8,12}$"))
            throw new PasswordNotValidException();
    }

    private void validateExistAccount(String email) throws AccountExistException {
        log.info("Validate an exist account");
        if(repository.findByEmail(email) != null)
            throw new AccountExistException();
    }

    private AccountGeneratedCommand parseToAccountGeneratedCommand(Account account) {
        return new AccountGeneratedCommand(
                account.getId(),
                account.getCreated().toString(),
                null,
                generate.generateToken(account),
                account.isActive()
        );
    }

    public Set<Phone> parseToPhone(List<CreateAccountPhoneCommand> phones) {
        return phones.stream()
                .map(it -> Phone.builder()
                        .id(UUID.randomUUID().toString())
                        .number(it.getNumber())
                        .cityCode(it.getCityCode())
                        .countryCode(it.getCountryCode())
                        .build())
                .collect(Collectors.toSet());
    }
}
