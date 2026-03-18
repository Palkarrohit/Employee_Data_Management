package com.example.SprinBooot_JPA_demo.Service;

import java.util.List;


import com.example.SprinBooot_JPA_demo.DTO.DepartmentResponseDTO;

public interface DepartmentService {

	List<DepartmentResponseDTO> getListOfDepartment();
}
