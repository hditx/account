package com.stratosphere.account.authenticated;

import com.stratosphere.account.domain.Account;
import com.stratosphere.account.dto.AuthenticatedAccountCommand;
import com.stratosphere.account.repository.AccountRepository;
import com.stratosphere.account.service.impl.AuthenticatedAccountImpl;
import com.stratosphere.account.shared.config.JwtGenerate;
import com.stratosphere.account.singup.mother.AccountMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;


public class AuthenticatedTest {

    @InjectMocks
    private AuthenticatedAccountImpl authenticatedAccount;

    @Mock
    private AccountRepository repository;

    @Mock
    private JwtGenerate generate;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void authenticatedAccount() {
        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        Mockito.when(securityContext.getAuthentication().getName()).thenReturn("asfzxd@asd.com");
        Account mock = AccountMother.generateAccount();
        Mockito.when(generate.generateToken(mock)).thenReturn("mock-token");
        Mockito.when(repository.findByEmail("asfzxd@asd.com")).thenReturn(mock);
        AuthenticatedAccountCommand command = authenticatedAccount.invoke();
        Assertions.assertEquals(mock.getId(), command.getId());

    }
}
