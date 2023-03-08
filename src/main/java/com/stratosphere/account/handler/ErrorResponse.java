package com.stratosphere.account.handler;

import java.io.Serializable;

public class ErrorResponse implements Serializable {

    private int code;
    private String detail;
    private String timeStamp;

    public ErrorResponse() {}

    public ErrorResponse(int code, String detail, String timeStamp) {
        this.code = code;
        this.detail = detail;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\" : " + code +
                ", \"detail\" : \"" + detail + "\"" +
                ", \"timeStamp\" : \"" + timeStamp + "\"" +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
