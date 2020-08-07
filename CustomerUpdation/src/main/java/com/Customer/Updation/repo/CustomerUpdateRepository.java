package com.Customer.Updation.repo;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Customer.Updation.models.CustomerUpdateDetail;
@Repository
public interface CustomerUpdateRepository extends JpaRepository<CustomerUpdateDetail, String> {

	@Query("select count(*) from CustomerUpdateDetail cust where cust.user_name=?1")
	public int custUserNameCount(String user_name);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update CustomerUpdateDetail c set c.first_name = :first_name  , c.address = :address , c.email = :email, c.pan = :pan , c.dob = :dob ,updatedby = :updatedby , updatedat = :updatedat where c.user_name = :user_name")
	public void updateCustomerDetails(@Param("user_name") String user_name, @Param("first_name") String first_name,
			@Param("address") String address, @Param("email") String email, @Param("pan") String pan,
			@Param("dob") String dob, @Param("updatedby") String updatedby, @Param("updatedat") Timestamp updatedat);
}
