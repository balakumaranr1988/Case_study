package com.Register.Loan.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Register.Loan.models.RegisterLoanDetail;

import com.Register.Loan.models.RegisterLoanResponse;

@SpringBootTest
public class RegisterLoanServiceTest {

	@Autowired
	private RegisterLoanService registerLoanService;
	
	
	/*
	 * @Test public void registerLoanTest() throws SQLException, IOException {
	 * java.sql.Timestamp date = new java.sql.Timestamp(new
	 * java.util.Date().getTime()); Random rand = new Random(); int loanid =
	 * rand.nextInt(1000) + 1; RegisterLoanDetail loanDetails = new
	 * RegisterLoanDetail(); loanDetails.setDuration("2months");
	 * loanDetails.setUser_name("venkatareddy");
	 * loanDetails.setLoan_amount("2lacks"); loanDetails.setLoan_type("house");
	 * loanDetails.setRateofint("12"); loanDetails.setUpdatedby("venkatareddy");
	 * loanDetails.setUpdatedat(date); loanDetails.setLoanid(loanid);
	 * RegisterLoanResponse registerLoan =
	 * registerLoanService.RegisterLoan(loanDetails);
	 * assertEquals("The Loan is applied", registerLoan.getMessage()); }
	 */
	
	
	
	@Test
	public void registerLoanTestForNoRecords() throws SQLException, IOException {
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		Random rand = new Random();
		int loanid = rand.nextInt(1000) + 1;
		RegisterLoanDetail loanDetails = new RegisterLoanDetail();
		loanDetails.setDuration("2months");
		loanDetails.setUser_name("xyz");
		loanDetails.setLoan_amount("2lacks");
		loanDetails.setLoan_type("house");
		loanDetails.setRateofint("12");
		loanDetails.setUpdatedby("venkatareddy");
		loanDetails.setUpdatedat(date);
		loanDetails.setLoanid(loanid);
		RegisterLoanResponse registerLoan = registerLoanService.RegisterLoan(loanDetails);
		assertEquals("Customer Does not Exixts", registerLoan.getMessage());
	}
	
}
