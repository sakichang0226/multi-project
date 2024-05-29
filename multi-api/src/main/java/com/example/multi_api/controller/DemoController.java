package com.example.multi_api.controller;

import com.demo.database.model.Demo;
import com.demo.database.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class DemoController {

    private final DemoService service;

    @GetMapping("/demo/{id}")
    public ResponseEntity<Demo> getDemo(@PathVariable("id") Long id) {

        Optional<Demo> demo = service.get(id);

        return new ResponseEntity<>(demo.get(), HttpStatus.OK);
    }

}
