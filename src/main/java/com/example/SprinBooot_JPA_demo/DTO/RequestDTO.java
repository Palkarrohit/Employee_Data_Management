package com.example.SprinBooot_JPA_demo.DTO;

import com.example.SprinBooot_JPA_demo.Entity.AddressEntity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RequestDTO {

	@NotBlank
	private String Req_empName;
	
	@Email(message = "Id sould be in email formatOnly")
	private String Req_empEmail;
	
	@Column(nullable = false)
	private String Req_department;
	
	@Column(nullable = false)
	@Nonnull()
	private double Req_salary;
	
	private AddressEntity Req_address;
	
	
	
	//-----------------------------------------------------------
	// Below are setter getters
	//-----------------------------------------------------------

	public String getReq_empName() {
		return Req_empName;
	}

	public void setReq_empName(String req_empName) {
		Req_empName = req_empName;
	}

	public String getReq_empEmail() {
		return Req_empEmail;
	}

	public void setReq_empEmail(String req_empEmail) {
		Req_empEmail = req_empEmail;
	}

	public String getReq_department() {
		return Req_department;
	}

	public void setReq_department(String req_department) {
		Req_department = req_department;
	}

	public double getReq_salary() {
		return Req_salary;
	}

	public void setReq_salary(double req_salary) {
		Req_salary = req_salary;
	}
	
	public void setReq_address(AddressEntity req_address)
	{
		Req_address=req_address;
		
	}
	public AddressEntity getReq_address()
	{
		return Req_address;
	}

}
