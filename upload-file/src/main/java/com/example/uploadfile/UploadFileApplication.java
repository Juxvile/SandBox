package com.example.uploadfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
@Configuration
public class UploadFileApplication {

	@Bean
	MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize(DataSize.parse("5MB"));
		factory.setMaxRequestSize(DataSize.parse("5MB"));
		return factory.createMultipartConfig();
	}

	public static void main(String[] args) {
		SpringApplication.run(UploadFileApplication.class, args);
	}
}
