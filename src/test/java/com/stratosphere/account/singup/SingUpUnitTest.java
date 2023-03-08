package com.stratosphere.account.singup;

import com.stratosphere.account.domain.Account;
import com.stratosphere.account.dto.AccountGeneratedCommand;
import com.stratosphere.account.dto.CreateAccountCommand;
import com.stratosphere.account.exceptions.AccountExistException;
import com.stratosphere.account.exceptions.EmailNotValidException;
import com.stratosphere.account.exceptions.PasswordNotValidException;
import com.stratosphere.account.repository.AccountRepository;
import com.stratosphere.account.service.CreateAccount;
import com.stratosphere.account.service.impl.CreateAccountImpl;
import com.stratosphere.account.singup.mother.AccountMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SingUpUnitTest {

    @InjectMocks
    private CreateAccountImpl createAccount;

    @Mock
    private AccountRepository repository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createAccountExistException() {
        Account mock = AccountMother.generateAccount();
        CreateAccountCommand commandMock = AccountMother.generate();
        Mockito.when(repository.findByEmail("asfzxd@asd.com")).thenReturn(mock);
        assertThrows(AccountExistException.class, () -> createAccount.invoke(commandMock));
    }

    @Test
    public void createAccountEmailException() {
        CreateAccountCommand commandMock = AccountMother.generateExceptionEmail();
        assertThrows(EmailNotValidException.class, () -> createAccount.invoke(commandMock));
    }

    @Test
    public void createAccountPasswordException() {
        CreateAccountCommand commandMock = AccountMother.generateExceptionPassword();
        assertThrows(PasswordNotValidException.class, () -> createAccount.invoke(commandMock));
    }

}
