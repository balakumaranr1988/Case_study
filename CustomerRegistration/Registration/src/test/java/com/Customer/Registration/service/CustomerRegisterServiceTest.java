package com.Customer.Registration.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Customer.Registration.models.CustomerRegistrationDetail;
import com.Customer.Registration.models.CustomerRegistrationResponse;

@SpringBootTest
public class CustomerRegisterServiceTest {
	@Autowired
	private CustomerRegistrationService customerRegisterService;
	
	@Test
	public void updateTest() throws SQLException, IOException {
		CustomerRegistrationDetail customer_dtl = new CustomerRegistrationDetail();
		customer_dtl.setAddress("chennai2");
		customer_dtl.setDob("18/06/1987");
		customer_dtl.setEmail("siva.venkatm@gmail.com");
		customer_dtl.setFirst_name("madhire");
		customer_dtl.setPan("BNGPM9521E");
		customer_dtl.setPassword("12345");
		customer_dtl.setUser_name("bala");
		CustomerRegistrationResponse custResponse = customerRegisterService.Registration(customer_dtl);
		assertEquals("The cutomer already exists", custResponse.getMessage());
	}
		  
	@Test
	public void testLoginfailure() throws SQLException, IOException {
		CustomerRegistrationDetail customer_dtl = new CustomerRegistrationDetail();

		customer_dtl.setPassword("12345");
		customer_dtl.setUser_name("123");

		CustomerRegistrationResponse custResponse = customerRegisterService.Login(customer_dtl);

		assertEquals("Invalid credentials/user not found", custResponse.getMessage());
	}
	
	@Test
	public void testLoginsuccess() throws SQLException, IOException {
		CustomerRegistrationDetail customer_dtl = new CustomerRegistrationDetail();

		customer_dtl.setPassword("pass");
		customer_dtl.setUser_name("bala");

		CustomerRegistrationResponse custResponse = customerRegisterService.Login(customer_dtl);

		assertEquals("Login Successful", custResponse.getMessage());
	}
	

}
