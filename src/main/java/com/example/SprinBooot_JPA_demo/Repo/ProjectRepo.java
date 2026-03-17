package com.example.SprinBooot_JPA_demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SprinBooot_JPA_demo.Entity.ProjectEntity;

public interface ProjectRepo extends JpaRepository<ProjectEntity, Long>{

}
