package com.example.userside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name = "ServerApp", configuration = SayHelloConfiguration.class)
public class UserSideApplication {

	final RestTemplate restTemplate;

	public UserSideApplication(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@LoadBalanced
	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/hi")
	public String hi(@RequestParam(value = "name", defaultValue = "Artaban") String name){
		String greeting = this.restTemplate.getForObject("http://localhost:8090/greeting", String.class);
		return String.format("%s, %s!",greeting,name);
	}

	public static void main(String[] args) {
		SpringApplication.run(UserSideApplication.class, args);
	}

}
