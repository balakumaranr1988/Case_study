package com.Customer.Registration.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import com.Customer.Registration.models.CustomerRegistrationDetail;
import com.Customer.Registration.models.CustomerRegistrationResponse;
import com.Customer.Registration.service.CustomerRegistrationService;


@RestController

public class CustomerRegistrationController {

	@Autowired
	private CustomerRegistrationService CustomerRegistrationService;
	
	@Autowired
	private CustomerRegistrationResponse CustomerRegistrationResponse;



	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public CustomerRegistrationResponse Update(@RequestBody CustomerRegistrationDetail Customer_dtl) throws Exception {
		CustomerRegistrationResponse = CustomerRegistrationService.Registration(Customer_dtl);
		return CustomerRegistrationResponse;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public CustomerRegistrationResponse Login(@RequestBody CustomerRegistrationDetail Customer_dtl) throws Exception {
		CustomerRegistrationResponse = CustomerRegistrationService.Login(Customer_dtl);
		return CustomerRegistrationResponse;
	}
}