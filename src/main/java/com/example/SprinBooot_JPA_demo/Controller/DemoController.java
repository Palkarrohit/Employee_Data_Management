package com.example.SprinBooot_JPA_demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SprinBooot_JPA_demo.DTO.RequestDTO;
import com.example.SprinBooot_JPA_demo.DTO.ResponseDTO;
import com.example.SprinBooot_JPA_demo.Entity.EmployeeEntity;
import com.example.SprinBooot_JPA_demo.Service.EmployeeService;

import jakarta.validation.Valid;

import com.example.SprinBooot_JPA_demo.Service.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class DemoController {

	@Autowired
	EmployeeService employeeService;
	    // ---------------------------------------------------------
	    // GET single employee
	    // ---------------------------------------------------------
	    @GetMapping("/{id}")
	    public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable Long id) {
	        EmployeeEntity employee = employeeService.getEmployee(id);
	        return ResponseEntity.ok(employee);
	    }

	    // ---------------------------------------------------------
	    // GET all employees
	    // ---------------------------------------------------------
	    @GetMapping
	    public ResponseEntity<List<ResponseDTO>> getAllEmployees() {
	        return ResponseEntity.ok(employeeService.getAllEmployees());
	    }

	    // ---------------------------------------------------------
	    // CREATE employee
	    // ---------------------------------------------------------
	    @PostMapping("/create")
	    public ResponseEntity<String> createEmployee(@Valid @RequestBody RequestDTO requestDTO) {
	        String message = employeeService.createEmployee(requestDTO);
	        return ResponseEntity.status(HttpStatus.CREATED).body(message);
	    }
	    
	    // ---------------------------------------------------------
	    // BULK CREATE employees
	    // ---------------------------------------------------------
	    
	    
	    @PostMapping("/bulk")
	    public ResponseEntity<String> createEmployeesBulk(@Valid @RequestBody RequestDTO[] requestDTOArray) {
	        String message = employeeService.createListOfEmployee(requestDTOArray);
	        return ResponseEntity.status(HttpStatus.CREATED).body(message);
	    }
	    
	    
	    // ---------------------------------------------------------
	    // UPDATE employee
	    // ---------------------------------------------------------
	    @PutMapping
	    public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody RequestDTO requestDTO) {
	        EmployeeEntity updated = employeeService.updateEmployee(requestDTO);
	        return ResponseEntity.ok(updated);
	    }
	    

	    // ---------------------------------------------------------
	    // DELETE employee
	    // ---------------------------------------------------------
	    @DeleteMapping("delete/{id}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
	        String message = employeeService.deleteEmployee(id);
	        return ResponseEntity.ok(message);
	    }

	   
	    
	

	    
	    
	    
	
}
