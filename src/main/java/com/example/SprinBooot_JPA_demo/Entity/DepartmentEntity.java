package com.example.SprinBooot_JPA_demo.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class DepartmentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long department_Id;
	
	private String departmentName;
	
	
	private String location;


	public Long getDepartment_Id() {
		return department_Id;
	}


	public void setDepartment_Id(Long department_Id) {
		this.department_Id = department_Id;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
