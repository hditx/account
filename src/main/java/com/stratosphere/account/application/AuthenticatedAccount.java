package com.stratosphere.account.application;

import com.stratosphere.account.domain.Account;
import com.stratosphere.account.domain.Phone;
import com.stratosphere.account.infrastructure.AccountRepository;
import com.stratosphere.account.shared.config.JwtGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthenticatedAccount {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private JwtGenerate generate;

    public AuthenticatedAccountCommand invoke() {
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
