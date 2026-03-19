package com.example.SprinBooot_JPA_demo.DTO;

import java.util.List;

import com.example.SprinBooot_JPA_demo.Entity.EmployeeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

public class DepartmentResponseDTO {
	//18/03/2026
	
	private String Res_departmentName;
	
	private String Res_departmentLocation;

	public String getRes_departmentName() {
		return Res_departmentName;
	}

	public void setRes_departmentName(String res_departmentName) {
		Res_departmentName = res_departmentName;
	}

	public String getRes_departmentLocation() {
		return Res_departmentLocation;
	}

	public void setRes_departmentLocation(String res_departmentLocation) {
		Res_departmentLocation = res_departmentLocation;
	}

   

}
