package com.stratosphere.account.domain.exceptions;

public final class PasswordNotValidException extends CustomException{
    private static final String detail = "Password not valid";
    private static final int code = 400;

    public PasswordNotValidException() {
        super(detail, code);
    }
}
