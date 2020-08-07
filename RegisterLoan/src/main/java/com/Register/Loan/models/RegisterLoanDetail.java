package com.Register.Loan.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="customer_loan")
public class RegisterLoanDetail {
	@Id
	String user_name;
	String loan_type;
	String loan_amount;
	String rateofint;
	String duration;
	Integer loanid;
	String updatedby;
	public Integer getLoanid() {
		return loanid;
	}
	public void setLoanid(Integer loanid) {
		this.loanid = loanid;
	}
	public String getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	public Timestamp getUpdatedat() {
		return updatedat;
	}
	public void setUpdatedat(Timestamp updatedat) {
		this.updatedat = updatedat;
	}
	Timestamp updatedat;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getLoan_type() {
		return loan_type;
	}
	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}
	public String getLoan_amount() {
		return loan_amount;
	}
	public void setLoan_amount(String loan_amount) {
		this.loan_amount = loan_amount;
	}
	public String getRateofint() {
		return rateofint;
	}
	public void setRateofint(String rateofint) {
		this.rateofint = rateofint;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

	


}
