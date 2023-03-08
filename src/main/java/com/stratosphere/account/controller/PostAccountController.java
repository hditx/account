package com.stratosphere.account.controller;

import com.stratosphere.account.service.CreateAccount;
import com.stratosphere.account.dto.CreateAccountCommand;
import com.stratosphere.account.exceptions.AccountExistException;
import com.stratosphere.account.exceptions.EmailNotValidException;
import com.stratosphere.account.exceptions.PasswordNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sing-up")
public class PostAccountController {
    @Autowired
    private CreateAccount createAccount;

    @PostMapping
    public ResponseEntity<?> invoke(@RequestBody CreateAccountCommand cmd)
            throws EmailNotValidException, PasswordNotValidException, AccountExistException {
        return ResponseEntity.status(HttpStatus.CREATED).body(createAccount.invoke(cmd));
    }
}
