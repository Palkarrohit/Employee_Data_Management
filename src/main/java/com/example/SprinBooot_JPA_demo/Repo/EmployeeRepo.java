package com.example.SprinBooot_JPA_demo.Repo;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.SprinBooot_JPA_demo.Entity.EmployeeEntity;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long>{

	@EntityGraph(attributePaths = {"address", "projects"})
	Page<EmployeeEntity> findAll(Pageable pageable);
	
	@Query("SELECT DISTINCT e FROM EmployeeEntity e JOIN FETCH e.projects")
	List<EmployeeEntity> findAllWithProjects();
}
