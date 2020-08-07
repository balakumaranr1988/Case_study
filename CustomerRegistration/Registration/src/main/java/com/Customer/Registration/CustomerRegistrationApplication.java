package com.Customer.Registration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CustomerRegistrationApplication {
	private static final Logger LOGGER = LogManager.getLogger(CustomerRegistrationApplication.class);
	public static void main(String[] args) {
		
		LOGGER.info("The CustomerRegistration app");
		LOGGER.debug("Debug level log message");
		LOGGER.error("Error level log message");
		SpringApplication.run(CustomerRegistrationApplication.class, args);
	}

}
