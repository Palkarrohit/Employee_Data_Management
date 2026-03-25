package com.example.SprinBooot_JPA_demo.Entity;

import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProjectEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long project_Id;
	
	private String projectName;
	
	
	private Long budget;
	
	@ManyToMany(mappedBy = "projects")
	@JsonIgnore
	private List<EmployeeEntity> employees;
	
	
//------------------------------------------------------------------------------------------------
		// Below are getter setters do not change it created using source
//------------------------------------------------------------------------------------------------
		
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
