package com.stratosphere.account.infrastructure.handler;

import com.stratosphere.account.domain.exceptions.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> invoke(CustomException customException) {
        return buildErrorResponse(customException);
    }

    private ResponseEntity<?> buildErrorResponse(CustomException customException) {
        List<ErrorResponse> errorList = new ArrayList<>();
        ErrorResponse error = new ErrorResponse(
                customException.getCode(),
                customException.getDetail(),
                customException.getTimeStamp().toString()
        );
        errorList.add(error);
        return ResponseEntity.status(customException.getCode()).body(errorList);
    }
}
