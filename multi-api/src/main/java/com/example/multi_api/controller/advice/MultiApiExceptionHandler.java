package com.example.multi_api.controller.advice;

import com.demo.demo_s3.exception.DemoS3BusinessException;
import com.demo.demo_s3.exception.DemoS3SystemException;
import com.example.dynamodb.demo.exception.DynamoDbDemoBusinessException;
import com.example.dynamodb.demo.exception.DynamoDbDemoSystemException;
import lombok.NonNull;
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

    private static String CODE = "code";

    private static String MESSAGE = "message";

    /**
     * DemoS3BusinessException発生時のエラーレスポンス
     * @param exception 例外クラス
     * @return エラーレスポンス
     */
    @ExceptionHandler(DemoS3BusinessException.class)
    public ResponseEntity<Object> handleException(DemoS3BusinessException exception){
        log.warn(exception.getMessage());

        return new ResponseEntity<>(createErrorInfo(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    /**
     * DemoS3SystemException発生時のエラーレスポンス
     * @param exception 例外クラス
     * @return エラーレスポンス
     */
    @ExceptionHandler(DemoS3SystemException.class)
    public ResponseEntity<Object> handleException(DemoS3SystemException exception){
        log.error(exception.getMessage());

        return new ResponseEntity<>(createErrorInfo(exception.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * DynamoDbDemoSystemException発生時のエラーレスポンス
     * @param exception 例外クラス
     * @return エラーレスポンス
     */
    @ExceptionHandler(DynamoDbDemoSystemException.class)
    public ResponseEntity<Object> handleException(DynamoDbDemoSystemException exception){
        log.error(exception.getMessage());

        return new ResponseEntity<>(createErrorInfo(exception.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * DynamoDbDemoBusinessException発生時のエラーレスポンス
     * @param exception 例外クラス
     * @return エラーレスポンス
     */
    @ExceptionHandler(DynamoDbDemoBusinessException.class)
    public ResponseEntity<Object> handleException(DynamoDbDemoBusinessException exception){
        log.warn(exception.getMessage());

        return new ResponseEntity<>(createErrorInfo(exception.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    /**
     * 例外クラスのメッセージに設定されているエラーコードとメッセージをレスポンスとして返す
     * @param message 例外クラスのメッセージ
     * @return　エラーレスポンス
     */
    public Map<String, String> createErrorInfo(@NonNull String message) {
        String[] error = message.split(":");
        Map<String, String> errorInfo = new HashMap<>();

        errorInfo.put(CODE, error[0]);
        errorInfo.put(MESSAGE, error[1]);

        return errorInfo;
    }


}
