package com.example.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AppRunner implements CommandLineRunner {
    public static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    public final GitHubLookupService gitHubLookupService;

    public AppRunner(GitHubLookupService gitHubLookupService) {
        this.gitHubLookupService = gitHubLookupService;
    }

    @Override
    public void run(String... args) throws Exception {
        long start = System.currentTimeMillis();

        CompletableFuture<User> page1 = gitHubLookupService.findUser("AlexeyGrishechkin"); // решил своих друзей поискать
        CompletableFuture<User> page2 = gitHubLookupService.findUser("Juxvile");
        CompletableFuture<User> page3 = gitHubLookupService.findUser("Spring-Projects");

        CompletableFuture.allOf(page1,page2,page3).join();

        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + page1.get());
        logger.info("--> " + page2.get());
        logger.info("--> " + page3.get());

    }
}
