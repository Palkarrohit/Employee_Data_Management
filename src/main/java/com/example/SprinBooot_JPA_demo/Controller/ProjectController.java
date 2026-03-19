package com.example.SprinBooot_JPA_demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SprinBooot_JPA_demo.DTO.DepartmentResponseDTO;
import com.example.SprinBooot_JPA_demo.DTO.ProjectResponseDTO;
import com.example.SprinBooot_JPA_demo.Service.ProjectService;


@RestController
@RequestMapping("/Projects")
public class ProjectController {
	
	@Autowired
	ProjectService projService;
	
	@GetMapping
	public ResponseEntity<List<ProjectResponseDTO>> getProjectList()
	{
		return ResponseEntity.ok(projService.getListOfProjects());
	}

}
