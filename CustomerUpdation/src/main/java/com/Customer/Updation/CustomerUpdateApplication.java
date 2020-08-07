package com.Customer.Updation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

public class CustomerUpdateApplication {
	private static final Logger LOGGER = LogManager.getLogger(CustomerUpdateApplication.class);
	public static void main(String[] args) {
		LOGGER.info("The CustomerUpdateApplication app");
		LOGGER.debug("Debug level log message");
		LOGGER.error("Error level log message");

		SpringApplication.run(CustomerUpdateApplication.class, args);
	}

}
