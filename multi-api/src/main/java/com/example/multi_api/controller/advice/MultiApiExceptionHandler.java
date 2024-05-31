package com.example.multi_api.controller.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class MultiApiExceptionHandler {

    @ExceptionHandler(IOException.class)
    public ResponseEntity<Object> exceptionHandler(Exception exception){
        log.warn(exception.getMessage());

        Map<String, String> errorInfo = new HashMap<>();
        errorInfo.put("code", "API_ERR_001");

        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
    }


}
