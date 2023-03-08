package com.stratosphere.account.exceptions;

public final class EmailNotValidException extends CustomException{
    private static final String detail = "Format email not valid";
    private static final int code = 400;
    public EmailNotValidException() {
        super(detail, code);
    }
}
