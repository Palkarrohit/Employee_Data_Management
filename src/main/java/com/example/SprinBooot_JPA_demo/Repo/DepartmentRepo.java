package com.example.SprinBooot_JPA_demo.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SprinBooot_JPA_demo.Entity.DepartmentEntity;
import com.example.SprinBooot_JPA_demo.Entity.ProjectEntity;

@Repository
public interface DepartmentRepo extends JpaRepository<DepartmentEntity, String> {

	//created on [12/03/26]
	
	Optional<DepartmentEntity> findByDepartmentName(String departmentName);
}
