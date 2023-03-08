package com.stratosphere.account.handler;

import com.stratosphere.account.exceptions.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(HandlerException.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> invoke(Exception exception) {
        if (CustomException.class.isAssignableFrom(exception.getClass())) {
            return buildErrorResponse((CustomException) exception);
        }
        return buildGenericExceptionResponse(exception);
    }

    private ResponseEntity<?> buildErrorResponse(CustomException customException) {
        List<ErrorResponse> errorList = new ArrayList<>();
        ErrorResponse error = new ErrorResponse(
                customException.getCode(),
                customException.getDetail(),
                customException.getTimeStamp().toString()
        );
        errorList.add(error);
        log.error("ERROR: " + customException.getDetail());
        return ResponseEntity.status(customException.getCode()).body(errorList);
    }

    private ResponseEntity<?> buildGenericExceptionResponse(Exception exception) {
        List<ErrorResponse> errorList = new ArrayList<>();
        ErrorResponse error = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(),
                new Date().toString()
        );
        errorList.add(error);
        log.error("ERROR: " + exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorList);
    }
}
