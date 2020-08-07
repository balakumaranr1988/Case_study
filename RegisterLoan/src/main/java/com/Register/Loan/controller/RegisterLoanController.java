package com.Register.Loan.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.Register.Loan.models.RegisterLoanResponse;
import com.Register.Loan.service.RegisterLoanService;



@RestController

public class RegisterLoanController {

	@Autowired
	private RegisterLoanService RegisterLoanService;
	
	@Autowired
	private RegisterLoanResponse RegisterLoanResponse;



	@RequestMapping(value = "/registerloan", method = RequestMethod.POST)
	public RegisterLoanResponse registerloan(@RequestBody com.Register.Loan.models.RegisterLoanDetail RegisterLoanDetail) throws Exception {
		RegisterLoanResponse = RegisterLoanService.RegisterLoan(RegisterLoanDetail);
		return RegisterLoanResponse;
	}
}