package com.Customer.Updation.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import com.Customer.Updation.models.CustomerUpdateDetail;
import com.Customer.Updation.models.CustomerUpdateResponse;
import com.Customer.Updation.service.CustomerUpdateService;


@RestController

public class CustomerUpdateController {

	@Autowired
	private CustomerUpdateService CustomerUpdateService;
	
	@Autowired
	private CustomerUpdateResponse CustomerUpdateResponse;



	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public CustomerUpdateResponse Update(@RequestBody CustomerUpdateDetail Customer_dtl) throws Exception {
		CustomerUpdateResponse = CustomerUpdateService.Updation(Customer_dtl);
		return CustomerUpdateResponse;
	}
}