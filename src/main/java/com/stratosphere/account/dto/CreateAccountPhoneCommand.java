package com.stratosphere.account.dto;

public final class CreateAccountPhoneCommand {
    private long number;
    private int cityCode;
    private String countryCode;

    public CreateAccountPhoneCommand() {}

    public long getNumber() {
        return number;
    }

    public int getCityCode() {
        return cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
