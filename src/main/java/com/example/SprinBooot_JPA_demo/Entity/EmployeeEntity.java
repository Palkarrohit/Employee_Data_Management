package com.example.SprinBooot_JPA_demo.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;

@Entity
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empID;
	
	@Column(nullable = false)
	private String empName;
	
	@Email(message = "Id sould be in email formatOnly")
	private String empEmail;
	
	@Column(nullable = false)
	private String department;
	
	@Column(nullable = false)
	private double salary;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressfk_id" ,referencedColumnName = "address_Id")
	private AddressEntity address;
	
	
	//---------------------------------------------------------------------------------
	
	// Below are getter setters do not change it created using source
	
	//---------------------------------------------------------------------------------
	
	public Long getEmpID() {
		return empID;
	}
	public void setEmpID(Long empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public AddressEntity getAddress() {
		return address;
	}
	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	
	
	
	

}
