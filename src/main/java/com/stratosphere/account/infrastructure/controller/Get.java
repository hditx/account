package com.stratosphere.account.infrastructure.controller;

import com.stratosphere.account.infrastructure.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Get {

    @Autowired
    private AccountRepository repository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> invoke() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(repository.findAll().toString());
    }
}
