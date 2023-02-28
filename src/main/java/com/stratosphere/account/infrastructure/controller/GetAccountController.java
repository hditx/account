package com.stratosphere.account.infrastructure.controller;

import com.stratosphere.account.application.AuthenticatedAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class GetAccountController {
    @Autowired
    private AuthenticatedAccount authenticatedAccount;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> invoke() {

        return ResponseEntity.status(HttpStatus.OK).body(authenticatedAccount.invoke());
    }
}
