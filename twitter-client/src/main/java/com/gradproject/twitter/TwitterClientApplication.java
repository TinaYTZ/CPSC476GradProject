package com.gradproject.twitter;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class TwitterClientApplication {
    private static Logger logger = Logger.getLogger(TwitterClientApplication.class.getName());
	public static void main(String[] args) {
		logger.info("SPRING VERSION: " + SpringVersion.getVersion());
		SpringApplication.run(TwitterClientApplication.class, args);
    
	}
}
