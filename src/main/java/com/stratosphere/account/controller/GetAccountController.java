package com.stratosphere.account.controller;

import com.stratosphere.account.service.AuthenticatedAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger log = LoggerFactory.getLogger(GetAccountController.class);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> invoke() {
        log.info("Access to authenticated account");
        return ResponseEntity.status(HttpStatus.OK).body(authenticatedAccount.invoke());
    }
}
