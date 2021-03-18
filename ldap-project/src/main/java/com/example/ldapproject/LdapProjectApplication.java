package com.example.ldapproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class LdapProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LdapProjectApplication.class, args);
	}

}
