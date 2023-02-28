package com.stratosphere.account.domain.exceptions;

import java.util.Date;

public class CustomException extends Exception{
    private String detail;
    private int code;
    private Date timeStamp;

    public CustomException(String detail, int code) {
        this.detail = detail;
        this.code = code;
        this.timeStamp = new Date();
    }

    public String getDetail() {
        return detail;
    }

    public int getCode() {
        return code;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }
}
