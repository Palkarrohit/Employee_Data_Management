package com.example.SprinBooot_JPA_demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SprinBooot_JPA_demo.DTO.ProjectResponseDTO;
import com.example.SprinBooot_JPA_demo.Entity.ProjectEntity;
import com.example.SprinBooot_JPA_demo.Repo.ProjectRepo;

@Service
public class ProjectServiceImpl implements ProjectService {
//18/03/26
	@Autowired
	ProjectRepo projectRepo;
	
	@Override
	public List<ProjectResponseDTO> getListOfProjects() {
		List<ProjectResponseDTO> ProjectList=new ArrayList<>();
	for(ProjectEntity project:projectRepo.findAll())
	{
		ProjectResponseDTO response=new ProjectResponseDTO();
		response.setProject_Id(project.getProject_Id());
		response.setRes_projectName(project.getProjectName());
		response.setRes_employees(project.getEmployees());
		
		ProjectList.add(response);
		
		
	}
		
		return ProjectList;
	}
	

}
