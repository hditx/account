package com.stratosphere.account.service;

import com.stratosphere.account.dto.AuthenticatedAccountCommand;

public interface AuthenticatedAccount {
    public AuthenticatedAccountCommand invoke();
}
