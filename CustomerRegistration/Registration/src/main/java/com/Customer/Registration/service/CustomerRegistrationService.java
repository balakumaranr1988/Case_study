package com.Customer.Registration.service;

import com.Customer.Registration.models.CustomerRegistrationResponse;
import com.Customer.Registration.repo.CustomerRegistrationRepository;
import com.Customer.Registration.models.CustomerRegistrationDetail;
/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LOGGER;*/

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class CustomerRegistrationService {

	@Autowired
	private CustomerRegistrationResponse CustomerRegistrationResponse;

	@Autowired
	private CustomerRegistrationRepository CustomerRegistrationRepository;

	private static final Logger LOGGER = LogManager.getLogger(CustomerRegistrationService.class);

	public CustomerRegistrationResponse Login(CustomerRegistrationDetail Customer_dtl)
			throws SQLException, IOException {
		LOGGER.info("Customer Register : Inside Customer Registration Service");
		boolean Flag = true;

		if ((Customer_dtl.getUser_name()).length() == 0) {
			LOGGER.info("User name cannot be blank");
			CustomerRegistrationResponse.setMessage("User name cannot be blank");
			Flag = false;
		} else if ((Customer_dtl.getPassword()).length() == 0) {
			LOGGER.info("Password cannot be blank");
			CustomerRegistrationResponse.setMessage("Password cannot be blank");
			Flag = false;
		}
		if (Flag == true) {

			int n = CustomerRegistrationRepository.loginCheck(Customer_dtl.getUser_name(), Customer_dtl.getPassword());

			if (n > 0) {
				LOGGER.info("Login Successful");
				CustomerRegistrationResponse.setMessage("Login Successful");
			} else {
				LOGGER.info("Invalid credentials/user not found");
				CustomerRegistrationResponse.setMessage("Invalid credentials/user not found");
			}

		}

		return CustomerRegistrationResponse;

	}

	public CustomerRegistrationResponse Registration(CustomerRegistrationDetail Customer_dtl)
			throws SQLException, IOException {
		LOGGER.info("Customer Register : Inside Customer Registration Service");

		boolean Flag = true;

		if ((Customer_dtl.getUser_name()).length() == 0) {
			LOGGER.info("User name cannot be blank");
			CustomerRegistrationResponse.setMessage("User name cannot be blank");
		} 
			  else if (Customer_dtl.getUser_name().length() > 0) {
			  
			  int n =
			  CustomerRegistrationRepository.userCheck(Customer_dtl.getUser_name()); 
			  if (n > 0)
			  {
				  LOGGER.info("The cutomer already exists");
			  CustomerRegistrationResponse.setMessage("The cutomer already exists"); 
			  Flag = false; }
			  
			  }
			 

		else if ((Customer_dtl.getFirst_name()).length() == 0) {
			LOGGER.info("customer name cannot be blank");
			CustomerRegistrationResponse.setMessage("Customer name cannot be blank");
			Flag = false;
		} else if ((Customer_dtl.getEmail()).length() == 0) {
			LOGGER.info("email cannot be blank");
			CustomerRegistrationResponse.setMessage("Email cannot be blank");
			Flag = false;
		} else if ((Customer_dtl.getPan()).length() == 0) {
			LOGGER.info("PAN cannot be blank");
			CustomerRegistrationResponse.setMessage("PAN number cannot be blank");
			Flag = false;
		} else if ((Customer_dtl.getDob()).length() == 0) {
			LOGGER.info("DOB cannot be blank");
			CustomerRegistrationResponse.setMessage("DOB cannot be blank");
			Flag = false;
		} else if ((Customer_dtl.getAddress()).length() == 0) {
			LOGGER.info("address name cannot be blank");
			CustomerRegistrationResponse.setMessage("Address cannot be blank");
			Flag = false;
		}

		if (Flag == true) {

			try {
				java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
				Customer_dtl.setUpdatedat(date);
				Customer_dtl.setUpdatedby(Customer_dtl.getUser_name());
				CustomerRegistrationRepository.save(Customer_dtl);
				LOGGER.info("The cutomer detail is updated");
				CustomerRegistrationResponse.setMessage("The cutomer detail is Registered");
			} catch (Exception e) {
				CustomerRegistrationResponse.setMessage("The cutomer already exists");
			}
		}

		return CustomerRegistrationResponse;

	}

}