package com.example.SprinBooot_JPA_demo.DTO;

public class DepartmentRequestDTO { // created [12/03/26]
	
	private String Req_departmentName;
	private String Req_departmentLocation;
	
	
	
	public String getReq_departmentName() {
		return Req_departmentName;
	}
	public void setReq_departmentName(String req_departmentName) {
		Req_departmentName = req_departmentName;
	}
	public String getReq_departmentLocation() {
		return Req_departmentLocation;
	}
	public void setReq_departmentLocation(String req_location) {
		Req_departmentLocation = req_location;
	}
	

}
