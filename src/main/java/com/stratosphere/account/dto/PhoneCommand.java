package com.stratosphere.account.dto;

public class PhoneCommand {
    private long number;
    private int cityCode;
    private String countryCode;

    public PhoneCommand(){}

    public PhoneCommand(long number, int cityCode, String countryCode) {
        this.number = number;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "{" +
                "\"number\": " + number +
                ", \"cityCode\": " + cityCode +
                ", \"countryCode\": \"" + countryCode + "\"" +
                "}";
    }
}
