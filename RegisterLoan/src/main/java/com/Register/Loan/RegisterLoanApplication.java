package com.Register.Loan;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class RegisterLoanApplication {
	private static final Logger LOGGER = LogManager.getLogger(RegisterLoanApplication.class);
	public static void main(String[] args) {
		LOGGER.info("The RegisterLoanApplication app");
		LOGGER.debug("Debug level log message");
		LOGGER.error("Error level log message");
		SpringApplication.run(RegisterLoanApplication.class, args);
	}

}
