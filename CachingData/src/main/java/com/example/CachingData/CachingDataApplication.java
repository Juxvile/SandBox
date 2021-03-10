package com.example.CachingData;

import com.example.CachingData.components.SimpleBookRepository;
import com.example.CachingData.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableCaching
@Configuration
public class CachingDataApplication {

	private static final Logger log = LoggerFactory.getLogger(CachingDataApplication.class);

	@Configuration
	static class Runner implements CommandLineRunner {
		@Autowired
		private BookRepository bookRepository;

		@Override
		public void run(String... args) throws Exception {
			log.info(".... Fetching books");
			log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
			log.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
			log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
			log.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
			log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
			log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
		}
	}

	@Bean
	public BookRepository bookRepository() {
		return new SimpleBookRepository();
	}

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("books");
	}

	public static void main(String[] args) {
		SpringApplication.run(CachingDataApplication.class, args);
	}

}
