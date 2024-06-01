package com.example.multi_api.controller;

import com.demo.demo_s3.Service.S3Service;
import com.demo.demo_s3.entity.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class S3Controller {

    private final S3Service s3Service;

    @GetMapping("/s3")
    public ResponseEntity<Map<String, String>> getYamlResponse() {
        Map<String, String> body = s3Service.getYamlFile();

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/s3/json")
    public ResponseEntity<Test> getTestResponse() {
        Test body = s3Service.getTest();

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/s3/json/all")
    public ResponseEntity<List<Test>> getTests() {
        List<Test> body = s3Service.getTestList();

        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
