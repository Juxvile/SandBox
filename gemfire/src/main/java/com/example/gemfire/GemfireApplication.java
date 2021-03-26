package com.example.gemfire;

import org.apache.geode.cache.client.ClientRegionShortcut;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.cache.config.EnableGemfireCaching;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnableLogging;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import java.util.Properties;

import static java.util.Arrays.asList;
import static java.util.stream.StreamSupport.stream;

@SpringBootApplication
@ClientCacheApplication(name = "AccessingDataGemFireApplication",logLevel = "fatal")
@EnableEntityDefinedRegions(basePackageClasses = Person.class, clientRegionShortcut = ClientRegionShortcut.LOCAL)
@EnableGemfireRepositories
public class GemfireApplication {

	public static void main(String[] args) {
		SpringApplication.run(GemfireApplication.class, args);
	}


	@Bean
	ApplicationRunner run (PersonRepository personRepository){
		return args -> {
			Person alice = new Person("Adult Alice",40);
			Person bob = new Person("Baby Bob",1);
			Person carol = new Person("Teen Carol",13);

			System.out.println("Before accessing data in Apache Geode...");

			asList(alice.getName(),bob.getName(),carol.getName()).forEach(name -> System.out.println("\t" + personRepository.findByName(name)));

			System.out.println("Query adults (over 18):");

			stream(personRepository.findByAgeGreaterThan(18).spliterator(),false).forEach(person -> System.out.println("\t" + person));

			System.out.println("Query babies (less than 5):");

			stream(personRepository.findByAgeLessThan(5).spliterator(), false).forEach(person -> System.out.println("\t" + person));

			System.out.println("Query teens (between 12 and 20):");

			stream(personRepository.findByAgeGreaterThanAndAgeLessThan(12,20).spliterator(), false).forEach(person -> System.out.println("\t" + person));
		};
	}
}
