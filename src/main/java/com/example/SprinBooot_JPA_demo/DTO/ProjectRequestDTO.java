package com.example.SprinBooot_JPA_demo.DTO;


import java.util.List;

import com.example.SprinBooot_JPA_demo.Entity.EmployeeEntity;

import jakarta.validation.constraints.NotNull;

public class ProjectRequestDTO {
    private Long project_Id;
	
	private String projectName;
	
	@NotNull
	private Long budget;
	
	
	private List<EmployeeEntity> employees;
	
	
	

	public Long getProject_Id() {
		return project_Id;
	}

	public void setProject_Id(Long project_Id) {
		this.project_Id = project_Id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Long getBudget() {
		return budget;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public List<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}
	
	
	
	

}
