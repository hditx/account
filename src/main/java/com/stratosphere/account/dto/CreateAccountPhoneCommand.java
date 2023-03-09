package com.stratosphere.account.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

@NoArgsConstructor
@Getter
@Setter
@Log
public final class CreateAccountPhoneCommand {
    private long number;
    private int cityCode;
    private String countryCode;

}
