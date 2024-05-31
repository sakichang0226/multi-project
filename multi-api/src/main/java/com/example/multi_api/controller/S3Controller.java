package com.example.multi_api.controller;

import com.demo.demo_s3.Service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class S3Controller {

    private final S3Service s3Service;

    @GetMapping("/s3")
    public ResponseEntity<Map<String, String>> getYamlResponse() throws IOException {
        Map<String, String> body = s3Service.getYamlFile();

        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
