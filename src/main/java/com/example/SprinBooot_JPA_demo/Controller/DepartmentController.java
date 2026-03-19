package com.example.SprinBooot_JPA_demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SprinBooot_JPA_demo.DTO.AddressResponseDTO;
import com.example.SprinBooot_JPA_demo.DTO.DepartmentResponseDTO;
import com.example.SprinBooot_JPA_demo.Service.DepartmentService;

@RestController
@RequestMapping("/Departments")
public class DepartmentController { //18/03/26

	@Autowired
	DepartmentService deptService;
	
	 @GetMapping
		public ResponseEntity<List<DepartmentResponseDTO>> getDepartmentList()
		{
			return ResponseEntity.ok(deptService.getListOfDepartment());
		}

}
