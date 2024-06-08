package com.example.multi_api.controller;

import com.example.dynamodb.demo.model.Todo;
import com.example.dynamodb.demo.service.TodoService;
import com.example.multi_api.request.TodoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class DynamoDbController {

    private final TodoService service;

    @GetMapping("todo/{key}")
    public ResponseEntity<Todo> getTodo(@PathVariable("key") String key, TodoRequest request) {
        System.out.println(request);

        Todo item = service.getTodo(key, request.getUser_id().toString());
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

}
