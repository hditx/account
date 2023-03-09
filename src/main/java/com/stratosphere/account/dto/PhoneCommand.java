package com.stratosphere.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Log
public class PhoneCommand {
    private long number;
    private int cityCode;
    private String countryCode;

    @Override
    public String toString() {
        return "{" +
                "\"number\": " + number +
                ", \"cityCode\": " + cityCode +
                ", \"countryCode\": \"" + countryCode + "\"" +
                "}";
    }
}
