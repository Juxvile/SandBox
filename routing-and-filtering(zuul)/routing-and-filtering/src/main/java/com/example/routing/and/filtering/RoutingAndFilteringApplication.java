package com.example.routing.and.filtering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class RoutingAndFilteringApplication {

	@RequestMapping(value = "/available")
	public String available(){
		return "Spring in action";
	}

	@RequestMapping(value = "/checked-out")
	public String checkedOut(){
		return "Spring Boot in action";
	}

	public static void main(String[] args) {
		SpringApplication.run(RoutingAndFilteringApplication.class, args);
	}

}
