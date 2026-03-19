package com.example.SprinBooot_JPA_demo.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Department")
public class DepartmentEntity {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long department_Id;
	@Id
	private String departmentName;
	private String departmentLocation;
	
	
	
	//One:Many mapping with Department:List<EmployeeEntity>
	//16/03/26 -->fetch = FetchType.LAZY  
    @OneToMany(mappedBy = "department" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   // @JoinColumn(name = "emp_idFK")---removed --> bbeacuse :Association 'DepartmentEntity.employees' is 'mappedBy' another entity
                                                           // and may not specify the '@JoinColumn'
   @JsonIgnore
    private List<EmployeeEntity> employees;
	
	
	
	
	
	
//-------------Below are setter getter methods ------------------------------------------------------------------	
	
//	public Long getDepartment_Id() {
//		return department_Id;
//	}
//
//
//	public void setDepartment_Id(Long department_Id) {
//		this.department_Id = department_Id;
//	}


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


	public List<EmployeeEntity> getEmployees() {
		return employees;
	}


	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}
	
	

}
