package com.stratosphere.account.singup;

import com.stratosphere.account.exceptions.AccountExistException;
import com.stratosphere.account.service.CreateAccount;
import com.stratosphere.account.dto.CreateAccountCommand;
import com.stratosphere.account.exceptions.EmailNotValidException;
import com.stratosphere.account.exceptions.PasswordNotValidException;
import com.stratosphere.account.repository.AccountRepository;
import com.stratosphere.account.singup.mother.AccountMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class SingUpIntegrationTests {
    @Autowired
    private CreateAccount createAccount;
    @Autowired
    private AccountRepository repository;

    @Test
    public void createAccount() throws AccountExistException, EmailNotValidException, PasswordNotValidException {
        CreateAccountCommand command = AccountMother.generate();
        createAccount.invoke(command);
    }

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

    @Test
    public void createAccountExistException() throws AccountExistException, EmailNotValidException, PasswordNotValidException {
        CreateAccountCommand command = AccountMother.generateDuplicate();
        createAccount.invoke(command);
        assertThrows(AccountExistException.class, () -> createAccount.invoke(command));
    }

}
