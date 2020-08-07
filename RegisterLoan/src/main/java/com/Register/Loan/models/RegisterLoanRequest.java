package com.Register.Loan.models;

import org.springframework.stereotype.Component;

@Component
public class RegisterLoanRequest {
	int id;
	String name;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

}
