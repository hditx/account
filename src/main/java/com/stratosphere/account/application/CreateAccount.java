package com.stratosphere.account.application;

import com.stratosphere.account.domain.Account;
import com.stratosphere.account.domain.exceptions.AccountExistException;
import com.stratosphere.account.domain.exceptions.EmailNotValidException;
import com.stratosphere.account.domain.exceptions.PasswordNotValidException;
import com.stratosphere.account.infrastructure.AccountRepository;
import com.stratosphere.account.shared.config.JwtGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.UUID;

@Service
public class CreateAccount {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private JwtGenerate generate;

    public AccountGeneratedCommand invoke(CreateAccountCommand cmd) throws EmailNotValidException, PasswordNotValidException, AccountExistException {
        validateEmail(cmd.getEmail());
        validatePassword(cmd.getPassword());
        validateExistAccount(cmd.getEmail());
        Account account = parseToUser(cmd);
        return parseToAccountGeneratedCommand(repository.save(account));
    }

    private Account parseToUser(CreateAccountCommand cmd) {
        return new Account(
                UUID.randomUUID().toString(),
                cmd.getName(),
                cmd.getEmail(),
                DigestUtils.md5DigestAsHex(cmd.getPassword().getBytes(StandardCharsets.UTF_8)),
                new HashSet<>(cmd.getPhones())
        );
    }

    private void validateEmail(String email) throws EmailNotValidException {
        if (!email.matches("^[a-z]*@([a-z]+\\.)+[a-z]{2,7}"))
            throw new EmailNotValidException();
    }

    private void validatePassword(String password) throws PasswordNotValidException {
        if(!password.matches("(?=.*[0-9].{2})(?=.*[a-z])(?=.*[A-Z].{1}).{8,12}$"))
            throw new PasswordNotValidException();
    }

    private void validateExistAccount(String email) throws AccountExistException {
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
}
