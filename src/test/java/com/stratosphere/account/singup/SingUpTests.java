package com.stratosphere.account.singup;

import com.stratosphere.account.application.CreateAccount;
import com.stratosphere.account.application.CreateAccountCommand;
import com.stratosphere.account.domain.exceptions.EmailNotValidException;
import com.stratosphere.account.domain.exceptions.PasswordNotValidException;
import com.stratosphere.account.infrastructure.AccountRepository;
import com.stratosphere.account.singup.mother.AccountMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class SingUpTests {
    @Autowired
    private CreateAccount createAccount;
    @Autowired
    private AccountRepository repository;

    @Test
    public void createAccountEmailException() {
        CreateAccountCommand command = AccountMother.generateExceptionEmail();
        assertThrows(EmailNotValidException.class, () -> createAccount.invoke(command));
    }

    @Test
    public void createAccountPasswordException() {
        CreateAccountCommand command = AccountMother.generateExceptionPassword();
        assertThrows(PasswordNotValidException.class, () -> createAccount.invoke(command));
    }

}
