package com.Register.Loan.service;

import com.Register.Loan.models.RegisterLoanResponse;
import com.Register.Loan.repository.RegisterLoanRepository;
import com.Register.Loan.models.RegisterLoanRequest;
import com.Register.Loan.models.RegisterLoanDetail;


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
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class RegisterLoanService {

	@Autowired
	private RegisterLoanResponse RegisterLoanResponse;

	@Autowired
	private RegisterLoanRepository registerLoanRepository;

	private static final Logger LOGGER = LogManager.getLogger(RegisterLoanService.class);

	public RegisterLoanResponse RegisterLoan(RegisterLoanDetail Loan_dtl) throws SQLException, IOException {
		LOGGER.info("CustomerUpdation : Inside Customer Updation Service");

		boolean Flag = true;

		RegisterLoanResponse response = new RegisterLoanResponse();

		if ((Loan_dtl.getUser_name()).length() == 0) {
			LOGGER.info("RegisterLoanApp : User name cannot be blank");
			response.setMessage("User name cannot be blank");
			Flag = false;
		} else if ((Loan_dtl.getDuration()).length() == 0) {
			LOGGER.info("RegisterLoanApp : Loan cannot be blank");
			response.setMessage("Loan Duration cannot be blank");
			Flag = false;
		} else if ((Loan_dtl.getLoan_amount()).length() == 0) {
			LOGGER.info("RegisterLoanApp : Loan Amount cannot be blank");
			response.setMessage("Loan Amount cannot be blank");
			Flag = false;
		} else if ((Loan_dtl.getLoan_type()).length() == 0) {
			LOGGER.info("RegisterLoanApp : Loan Type cannot be blank");
			response.setMessage("Loan Type cannot be blank");
			Flag = false;
		} else if ((Loan_dtl.getRateofint()).length() == 0) {
			LOGGER.info("RegisterLoanApp : Rate of Interest cannot be blank");
			response.setMessage("Rate of Interest cannot be blank");
			Flag = false;
		}

		if (Flag == true) {
			try {

				int n = 0;
				n = registerLoanRepository.loanUserDetailsCount(Loan_dtl.getUser_name());
				if (n > 0) {
					int m=0;
					m = registerLoanRepository.loanUserDetailsCheck(Loan_dtl.getUser_name(),Loan_dtl.getLoan_type());
					if ( m > 0)
					{
						response.setMessage("RegisterLoanApp : This particular loan type already exixts for the customer");
						LOGGER.info("RegisterLoanApp : This particular loan type already exixts for the customer");
						
					}
					else
					{	
					java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
					Random rand = new Random();

					int loanid = rand.nextInt(1000) + 1;
					Loan_dtl.setLoanid(loanid);
					Loan_dtl.setUpdatedat(date);
					Loan_dtl.setUpdatedby(Loan_dtl.getUser_name());
					
					

					try {
						registerLoanRepository.save(Loan_dtl);
						LOGGER.info("RegisterLoanApp : The Loan is applied");
						response.setMessage("The Loan is applied");
					} catch (Exception e) {
						LOGGER.info("RegisterLoanApp - error", e);
						response.setMessage("error");

					}
					}

				}

				else {
					LOGGER.info("RegisterLoanApp : Customer Does not Exixts");
					response.setMessage("Customer Does not Exixts");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				LOGGER.info("RegisterLoanApp : Customer Does not Exixts", e);
				e.printStackTrace();
			}

		}
		return response;

	}

	public RegisterLoanResponse getRegisterLoanResponse() {
		return RegisterLoanResponse;
	}

	public void setRegisterLoanResponse(RegisterLoanResponse registerLoanResponse) {
		RegisterLoanResponse = registerLoanResponse;
	}

}