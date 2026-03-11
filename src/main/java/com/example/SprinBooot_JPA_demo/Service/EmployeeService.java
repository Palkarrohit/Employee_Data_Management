package com.example.SprinBooot_JPA_demo.Service;

import java.util.List;

import com.example.SprinBooot_JPA_demo.DTO.RequestDTO;
import com.example.SprinBooot_JPA_demo.DTO.ResponseDTO;
import com.example.SprinBooot_JPA_demo.Entity.EmployeeEntity;

public interface EmployeeService {
	
	public List<ResponseDTO> getAllEmployees();
	
	EmployeeEntity getEmployee(Long empId);
	
	String createEmployee(RequestDTO requestDTO);
	
	EmployeeEntity updateEmployee(RequestDTO requestDTO);
	
	String deleteEmployee(Long empId);
	
	String createListOfEmployee(RequestDTO[] requestDTOArray);
	

}
