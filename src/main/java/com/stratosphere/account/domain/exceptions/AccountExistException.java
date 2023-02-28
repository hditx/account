package com.stratosphere.account.domain.exceptions;

public final class AccountExistException extends CustomException{
    private static final String detail = "Account is already";
    private static final int code = 400;

    public AccountExistException() {
        super(detail, code);
    }
}
