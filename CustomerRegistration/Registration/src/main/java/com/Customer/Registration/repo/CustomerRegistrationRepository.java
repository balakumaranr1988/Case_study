package com.Customer.Registration.repo;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Customer.Registration.models.CustomerRegistrationDetail;

@Repository
public interface CustomerRegistrationRepository extends JpaRepository<CustomerRegistrationDetail, String> {

	@Query("select count(*) from CustomerRegistrationDetail cust where cust.user_name=?1 and cust.password=?2")
	public int loginCheck(String user_name, String password);
	
	@Query("select count(*) from CustomerRegistrationDetail cust where cust.user_name=?1")
	public int userCheck(String user_name);

}
