package com.example.SprinBooot_JPA_demo.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

public class ResponseDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Res_empID;
	
	@Column(nullable = false)
	private String Res_empName;
	
	@Email(message = "Id sould be in email formatOnly")
	private String Res_empEmail;
	
	@Column(nullable = false)
	private String Res_department;
	
	@Column(nullable = false)
	private double Res_salary;

	public Long getRes_empID() {
		return Res_empID;
	}

	public void setRes_empID(Long res_empID) {
		Res_empID = res_empID;
	}

	public String getRes_empName() {
		return Res_empName;
	}

	public void setRes_empName(String res_empName) {
		Res_empName = res_empName;
	}

	public String getRes_empEmail() {
		return Res_empEmail;
	}

	public void setRes_empEmail(String res_empEmail) {
		Res_empEmail = res_empEmail;
	}

	public String getRes_department() {
		return Res_department;
	}

	public void setRes_department(String res_department) {
		Res_department = res_department;
	}

	public double getRes_salary() {
		return Res_salary;
	}

	public void setRes_salary(double res_salary) {
		Res_salary = res_salary;
	}
}
