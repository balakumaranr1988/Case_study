package com.Register.Loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.Register.Loan.models.RegisterLoanDetail;


public interface RegisterLoanRepository extends JpaRepository<RegisterLoanDetail, String> {

	@Query("select count(*) from CustomerUpdateDetail cust where cust.user_name=?1")
	public int loanUserDetailsCount(String user_name);
	@Query("select count(*) from RegisterLoanDetail cust where cust.user_name=?1 and cust.loan_type=?2")
	public int loanUserDetailsCheck(String user_name,String loan_type);
}
