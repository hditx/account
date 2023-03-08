package com.stratosphere.account.service.impl;

import com.stratosphere.account.domain.Account;
import com.stratosphere.account.domain.Phone;
import com.stratosphere.account.dto.AuthenticatedAccountCommand;
import com.stratosphere.account.dto.PhoneCommand;
import com.stratosphere.account.repository.AccountRepository;
import com.stratosphere.account.service.AuthenticatedAccount;
import com.stratosphere.account.shared.config.JwtGenerate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthenticatedAccountImpl implements AuthenticatedAccount {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private JwtGenerate generate;


    private final Logger log = LoggerFactory.getLogger(AuthenticatedAccountImpl.class);

    @Override
    public AuthenticatedAccountCommand invoke() {
        log.info("Authenticated who user is");
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return parseToAccountCmd(repository.findByEmail(email));
    }

    public AuthenticatedAccountCommand parseToAccountCmd(Account account) {
        String token = generateToken(account);
        List<PhoneCommand> phones = getPhones(account.getPhones());
        return new AuthenticatedAccountCommand(
            account.getId(),
            account.getCreated().toString(),
            new Date().toString(),
            token,
            account.isActive(),
            account.getName(),
            account.getEmail(),
            account.getPassword(),
            phones
        );
    }

    private List<PhoneCommand> getPhones(Set<Phone> phones) {
        return phones
            .stream()
            .map(it ->
                new PhoneCommand(it.getNumber(), it.getCityCode(), it.getCountryCode())
            ).collect(Collectors.toList());
    }

    private String generateToken(Account account) {
        return generate.generateToken(account);
    }
}
