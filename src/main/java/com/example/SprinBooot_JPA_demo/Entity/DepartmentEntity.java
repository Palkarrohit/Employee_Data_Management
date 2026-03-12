package com.example.SprinBooot_JPA_demo.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class DepartmentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long department_Id;
	
	private String departmentName;
	private String departmentLocation;
	
	//One:Many mapping with Department:List<EmployeeEntity>
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_idFK")
    private List<EmployeeEntity> employees;
	
	
	
	
	
	
//-------------Below are setter getter methods ------------------------------------------------------------------	
	
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


	public String getDepartmentLocation() {
		return departmentLocation;
	}


	public void setDepartmentLocation(String location) {
		this.departmentLocation = location;
	}
	
	

}
