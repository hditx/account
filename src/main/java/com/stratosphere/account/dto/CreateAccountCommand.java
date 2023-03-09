package com.stratosphere.account.dto;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Log
public final class CreateAccountCommand {

    private String name;
    private String email;
    private String password;
    private List<CreateAccountPhoneCommand> phones;
}
