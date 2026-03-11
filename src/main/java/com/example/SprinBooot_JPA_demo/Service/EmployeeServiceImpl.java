package com.example.SprinBooot_JPA_demo.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SprinBooot_JPA_demo.DTO.RequestDTO;
import com.example.SprinBooot_JPA_demo.DTO.ResponseDTO;
import com.example.SprinBooot_JPA_demo.Entity.AddressEntity;
import com.example.SprinBooot_JPA_demo.Entity.EmployeeEntity;
import com.example.SprinBooot_JPA_demo.Repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepo empRepo;
	
	@Override
	public EmployeeEntity getEmployee(Long empId) {
		
		return empRepo.findById(empId).orElseThrow();
		
	}

	@Override
	public String createEmployee(RequestDTO requestDTO) {
		
		EmployeeEntity request=new EmployeeEntity();
		request.setDepartment(requestDTO.getReq_department());
		request.setEmpEmail(requestDTO.getReq_empEmail());
		request.setEmpName(requestDTO.getReq_empName());
		request.setSalary(requestDTO.getReq_salary());
		request.setEmpID(request.getEmpID());
		
		AddressEntity address=new AddressEntity();
		address.setAddress_Id(null);
		address.setCity(null);
		address.setState(null);
		address.setPincode(null);
		
		empRepo.save(request);
		
		
		return "UserCreated Succeefully";
	}

	@Override
	public EmployeeEntity updateEmployee(RequestDTO requestDTO) {
		EmployeeEntity request=new EmployeeEntity();
		request.setDepartment(requestDTO.getReq_department());
		request.setEmpEmail(requestDTO.getReq_empEmail());
		request.setEmpName(requestDTO.getReq_empName());
		request.setSalary(requestDTO.getReq_salary());
		request.setEmpID(request.getEmpID());
		
		
		return empRepo.save(request);
		
	}

	@Override
	public String deleteEmployee(Long empId) {
		EmployeeEntity entity= new EmployeeEntity();
		if(empId.equals(entity.getEmpID()))
		{
		empRepo.deleteById(empId);
		}
		else
		{
			throw new RuntimeException("Not such Id exsist");
		}
		return "Employee Deleted : "+empId;
	}

	@Override
	public List<ResponseDTO> getAllEmployees() {
		
		List<ResponseDTO> resposeList=new ArrayList<>();
	    for( EmployeeEntity employee: empRepo.findAll())	
	    {
	    	ResponseDTO response=new ResponseDTO();
	    	
	    	response.setRes_empID(employee.getEmpID());
	    	response.setRes_empName(employee.getEmpName());
	    	response.setRes_department(employee.getDepartment());
	    	response.setRes_empEmail(employee.getEmpEmail());
	    	response.setRes_salary(employee.getSalary());
	    	
	    	resposeList.add(response);
	    	
	    	
	     	
	    }
	   
	    
	    return resposeList;
		
	}

	
	@Override
	public String createListOfEmployee(RequestDTO[] requestDTOArray) {
		
         
		
         List<Long> empIdList=new ArrayList<>();
		for(RequestDTO requestDTO:requestDTOArray)
		{EmployeeEntity request=new EmployeeEntity();
			request.setDepartment(requestDTO.getReq_department());
			request.setEmpEmail(requestDTO.getReq_empEmail());
			request.setEmpName(requestDTO.getReq_empName());
			request.setSalary(requestDTO.getReq_salary());
			request.setEmpID(request.getEmpID());
			
			empRepo.save(request);
			empIdList.add(request.getEmpID());
			
		}
		
		return "All users saved : "+empIdList;
	}
}
