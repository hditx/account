package com.stratosphere.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Log
public class AccountGeneratedCommand implements Serializable {
    private String id;
    private String created;
    private String lastLogin;
    private String token;
    private boolean isActive;
}
