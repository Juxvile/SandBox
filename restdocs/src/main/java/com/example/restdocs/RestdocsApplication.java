package com.example.restdocs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example")
@SpringBootApplication
public class RestdocsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestdocsApplication.class, args);
	}

}
