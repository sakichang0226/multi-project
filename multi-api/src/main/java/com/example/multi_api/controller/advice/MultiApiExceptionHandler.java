package com.example.multi_api.controller.advice;

import com.demo.demo_s3.exception.DemoS3BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
@Slf4j
public class MultiApiExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * IOException発生時のエラーレスポンス
     * @param exception 例外クラス
     * @return エラーレスポンス
     */
    @ExceptionHandler(IOException.class)
    public ResponseEntity<Object> exceptionHandler(Exception exception){
        log.warn(exception.getMessage());

        Map<String, String> errorInfo = new HashMap<>();
        errorInfo.put("code", "API_ERR_001");

        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
    }

    /**
     * DemoS3BusinessException発生時のエラーレスポンス
     * @param exception 例外クラス
     * @return エラーレスポンス
     */
    @ExceptionHandler(DemoS3BusinessException.class)
    public ResponseEntity<Object> handleException(DemoS3BusinessException exception){
        log.warn(exception.getMessage());

        Map<String, String> errorInfo = new HashMap<>();
        errorInfo.put("code", "API_ERR_001");

        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
    }


}
