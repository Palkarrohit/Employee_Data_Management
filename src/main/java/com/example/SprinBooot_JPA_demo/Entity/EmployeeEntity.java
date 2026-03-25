package com.example.SprinBooot_JPA_demo.Entity;

import java.util.List;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empID;
	
	@Column(nullable = false)
	private String empName;
	
	@Email(message = "Id sould be in email formatOnly")
	private String empEmail;
	
//	@Column(nullable = false)    --> depericated as method mapping done
//	private String department;
	//many:one mapping List<EmployeeEntity>;Department
	//16/03/26 --fetch = FetchType.LAZY => Data loads only when accessed.
		@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JoinColumn(name = "dept_id_FK")
		private DepartmentEntity department;
	
	
	
	@Column(nullable = false)
	private double salary;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressfk_id" ,referencedColumnName = "address_Id")
	private AddressEntity address;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "Employee_Project",
			joinColumns = @JoinColumn(referencedColumnName = "empID"),
			inverseJoinColumns = @JoinColumn(referencedColumnName = "project_Id")
			)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@BatchSize(size = 10)
	private List<ProjectEntity> projects;
	
	
	
	
//------------------------------------------------------------------------------------------------
	// Below are getter setters do not change it created using source
//------------------------------------------------------------------------------------------------
	
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
	
	
//	public String getDepartment() {
//		return department;
//	}
//	public void setDepartment(String department) {
//		this.department = department;
//	}
	
	
	//new setter getters for department
	public DepartmentEntity getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentEntity department) {
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
	public List<ProjectEntity> getProjects() {
		return projects;
	}
	public void setProjects(List<ProjectEntity> projects) {
		this.projects = projects;
	}
	
	
	
	

}
