package com.example.multi_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {
		"com.example.multi_api",
		"com.demo.database"
})
public class MultiApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiApiApplication.class, args);
	}

}
