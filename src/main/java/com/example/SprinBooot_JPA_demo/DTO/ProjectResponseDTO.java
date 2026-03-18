package com.example.SprinBooot_JPA_demo.DTO;

import java.util.List;

import com.example.SprinBooot_JPA_demo.Entity.EmployeeEntity;

import jakarta.validation.constraints.NotNull;

public class ProjectResponseDTO {
	//18/03/2026
	    private Long project_Id;
		
		private String Res_projectName;
		
		
		private Long Res_budget;
		
		
		private List<EmployeeEntity> Res_employees;


		public Long getProject_Id() {
			return project_Id;
		}


		public void setProject_Id(Long project_Id) {
			this.project_Id = project_Id;
		}


		public String getRes_projectName() {
			return Res_projectName;
		}


		public void setRes_projectName(String res_projectName) {
			Res_projectName = res_projectName;
		}


		public Long getRes_budget() {
			return Res_budget;
		}


		public void setRes_budget(Long res_budget) {
			Res_budget = res_budget;
		}


		public List<EmployeeEntity> getRes_employees() {
			return Res_employees;
		}


		public void setRes_employees(List<EmployeeEntity> res_employees) {
			Res_employees = res_employees;
		}

}
