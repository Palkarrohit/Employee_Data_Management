package com.example.SprinBooot_JPA_demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SprinBooot_JPA_demo.DTO.DepartmentResponseDTO;

import com.example.SprinBooot_JPA_demo.Entity.DepartmentEntity;

import com.example.SprinBooot_JPA_demo.Repo.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentRepo deptRepo;
	
	@Override
	public List<DepartmentResponseDTO> getListOfDepartment() {
	
		
		List<DepartmentResponseDTO> DepartmentList=new ArrayList<>();
		
		for(DepartmentEntity department:deptRepo.findAll())
		{
			DepartmentResponseDTO response=new DepartmentResponseDTO();
			response.setRes_departmentName(department.getDepartmentName());
			response.setRes_departmentLocation(department.getDepartmentLocation());
			
			
			DepartmentList.add(response);
			
			
		}
			
			return DepartmentList;
	}
	
	

}
