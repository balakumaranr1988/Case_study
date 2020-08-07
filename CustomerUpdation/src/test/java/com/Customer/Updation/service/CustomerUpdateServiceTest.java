package com.Customer.Updation.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Customer.Updation.models.CustomerUpdateDetail;
import com.Customer.Updation.models.CustomerUpdateResponse;

@SpringBootTest
public class CustomerUpdateServiceTest {
	@Autowired
	private CustomerUpdateService customerUpdateService;
	
	@Test
	public void updateTest() throws SQLException, IOException {
		CustomerUpdateDetail customer_dtl = new CustomerUpdateDetail();
		customer_dtl.setAddress("chennai2");
		customer_dtl.setDob("18/06/1987");
		customer_dtl.setEmail("siva.venkatm@gmail.com");
		customer_dtl.setFirst_name("madhire");
		customer_dtl.setPan("BNGPM9521E");
		customer_dtl.setPassword("12345");
		customer_dtl.setUser_name("bala");
		CustomerUpdateResponse custResponse = customerUpdateService.Updation(customer_dtl);
		assertEquals("The cutomer detail is updated", custResponse.getMessage());
	}
		  
	@Test
	public void updateTestNoRecords() throws SQLException, IOException {
		CustomerUpdateDetail customer_dtl = new CustomerUpdateDetail();

		customer_dtl.setAddress("chennai2");
		customer_dtl.setDob("18/06/1987");
		customer_dtl.setEmail("siva.venkatm@gmail.com");
		customer_dtl.setFirst_name("madhire");
		customer_dtl.setPan("BNGPM9521E");
		customer_dtl.setPassword("12345");
		customer_dtl.setUser_name("123");

		CustomerUpdateResponse custResponse = customerUpdateService.Updation(customer_dtl);

		assertEquals("Customer Does not Exixts", custResponse.getMessage());
	}
	

}
