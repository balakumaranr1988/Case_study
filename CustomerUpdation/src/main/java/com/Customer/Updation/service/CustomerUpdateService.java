package com.Customer.Updation.service;

import com.Customer.Updation.models.CustomerUpdateResponse;
import com.Customer.Updation.repo.CustomerUpdateRepository;

import com.Customer.Updation.models.CustomerUpdateDetail;
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
public class CustomerUpdateService {

	@Autowired
	private CustomerUpdateResponse CustomerUpdateResponse;
	
	@Autowired
	private CustomerUpdateRepository customerRepository;

	private static final Logger LOGGER = LogManager.getLogger(CustomerUpdateService.class);

	

	public CustomerUpdateResponse Updation(CustomerUpdateDetail Customer_dtl) throws SQLException, IOException {
		LOGGER.info("CustomerUpdation : Inside Customer Updation Service");

		boolean Flag = true;

		if ((Customer_dtl.getUser_name()).length() == 0) {
			LOGGER.info("User name cannot be blank");
			CustomerUpdateResponse.setMessage("User name cannot be blank");
			Flag = false;
		} else if ((Customer_dtl.getFirst_name()).length() == 0) {
			LOGGER.info("customer name cannot be blank");
			CustomerUpdateResponse.setMessage("Customer name cannot be blank");
			Flag = false;
		} else if ((Customer_dtl.getEmail()).length() == 0) {
			LOGGER.info("email cannot be blank");
			CustomerUpdateResponse.setMessage("Email cannot be blank");
			Flag = false;
		} else if ((Customer_dtl.getPan()).length() == 0) {
			LOGGER.info("PAN cannot be blank");
			CustomerUpdateResponse.setMessage("PAN number cannot be blank");
			Flag = false;
		} else if ((Customer_dtl.getDob()).length() == 0) {
			LOGGER.info("DOB cannot be blank");
			CustomerUpdateResponse.setMessage("DOB cannot be blank");
			Flag = false;
		} else if ((Customer_dtl.getAddress()).length() == 0) {
			LOGGER.info("address name cannot be blank");
			CustomerUpdateResponse.setMessage("Address cannot be blank");
			Flag = false;
		}
		if (Flag == true) {
			try {
				
				int n = 0;
				
				n = customerRepository.custUserNameCount(Customer_dtl.getUser_name());

				if (n > 0) {

		
					 try {
					java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
					customerRepository.updateCustomerDetails(Customer_dtl.getUser_name(), Customer_dtl.getFirst_name(), Customer_dtl.getAddress(), Customer_dtl.getEmail(), Customer_dtl.getPan(), Customer_dtl.getDob(), Customer_dtl.getUser_name(), date);
					LOGGER.info("The cutomer detail is updated");
					CustomerUpdateResponse.setMessage("The cutomer detail is updated");
					 }catch (Exception e) {
						 CustomerUpdateResponse.setMessage("error");
					}
				}

				else {

					CustomerUpdateResponse.setMessage("Customer Does not Exixts");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return CustomerUpdateResponse;

	}

}