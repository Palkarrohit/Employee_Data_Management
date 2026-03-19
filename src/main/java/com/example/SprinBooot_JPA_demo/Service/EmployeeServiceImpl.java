package com.example.SprinBooot_JPA_demo.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SprinBooot_JPA_demo.DTO.AddressRequestDTO;
import com.example.SprinBooot_JPA_demo.DTO.DepartmentRequestDTO;
import com.example.SprinBooot_JPA_demo.DTO.ProjectRequestDTO;
import com.example.SprinBooot_JPA_demo.DTO.RequestDTO;
import com.example.SprinBooot_JPA_demo.DTO.ResponseDTO;
import com.example.SprinBooot_JPA_demo.Entity.AddressEntity;
import com.example.SprinBooot_JPA_demo.Entity.DepartmentEntity;
import com.example.SprinBooot_JPA_demo.Entity.EmployeeEntity;
import com.example.SprinBooot_JPA_demo.Entity.ProjectEntity;
import com.example.SprinBooot_JPA_demo.Repo.AddressRepo;
import com.example.SprinBooot_JPA_demo.Repo.DepartmentRepo;
import com.example.SprinBooot_JPA_demo.Repo.EmployeeRepo;
import com.example.SprinBooot_JPA_demo.Repo.ProjectRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepo empRepo;
	
	@Autowired
	DepartmentRepo deptRepo;
	
	@Autowired
	AddressRepo addRepo;
	
	@Autowired
	ProjectRepo projectRepo;

//==================================================================================================	
//  Get Single Employee Method
//==================================================================================================	

	@Transactional(readOnly = true)
	@Override
	public ResponseDTO getEmployee(Long empId) {
		
		EmployeeEntity employee= empRepo.findById(empId).orElseThrow(()->new RuntimeException("Employee ID not exsits"));
		ResponseDTO response = mapToEmployeeResponseDTO(employee);
		return response;
	}
	
//==================================================================================================	
//  Get All Employee Method
//==================================================================================================	
	
	@Transactional(readOnly = true)
	@Override
	public List<ResponseDTO> getAllEmployees() {
		
		List<ResponseDTO> resposeList=new ArrayList<>();
	    for( EmployeeEntity employee: empRepo.findAllWithProjects())	
	    {
    	ResponseDTO response = mapToEmployeeResponseDTO(employee);
	    	
	    	resposeList.add(response);
	    }
	   
	    
	    return resposeList;
		
	}

//==================================================================================================	
//  Single Employee Creation Method
//==================================================================================================	
	@Transactional
	@Override
	public String createEmployee(RequestDTO requestDTO) {

		EmployeeEntity request= mapToEmployeeEntity(requestDTO);	
		
		empRepo.save(request);
		
		//End-Adding address one:one by @Rohit -[12/03/2026]
		
		return "UserCreated Succeefully : " +"[ "+request.getEmpID()+" ]";
	}

//==================================================================================================	
//  Update Method
//==================================================================================================	
	
	@Transactional
	@Override
	public EmployeeEntity updateEmployee(RequestDTO requestDTO) {

      	EmployeeEntity request=mapToEmployeeEntity(requestDTO);
		return empRepo.save(request);
		
	}
	
//==================================================================================================	
//  Bulk Creation Method
//==================================================================================================	
	@Transactional
	@Override
	public String createListOfEmployee(RequestDTO[] requestDTOArray) {
	  
		List<Long> empIdList=new ArrayList<>();
	   
		for(RequestDTO requestDTO:requestDTOArray)
		{
	     	EmployeeEntity request=	mapToEmployeeEntity(requestDTO);
					
			empRepo.save(request);
			empIdList.add(request.getEmpID());
			
		}
		
		return "All users saved : "+empIdList;
	}
	
//==================================================================================================	
//    Delete Method
//==================================================================================================	
	@Transactional
	@Override
	public String deleteEmployee(Long empId) {
		EmployeeEntity entity= empRepo.findById(empId)
				                 .orElseThrow(()->new RuntimeException("Not such Id exsist"));
		
		empRepo.delete(entity);
		
		return "Employee Deleted : "+empId;
	}
	
//==================================================================================================	
//  Pagination Method to get employee data 19/03/2026
//==================================================================================================	

	@Transactional(readOnly = true)
 @Override
public List<ResponseDTO> getEmployeeWithPagination(int page, int size) {
	Pageable pageable=PageRequest.of(page, size);
	Page<EmployeeEntity> employeePage=empRepo.findAll(pageable);
	
	List<ResponseDTO> employeeList=new ArrayList<>();
	for(EmployeeEntity employee:employeePage.getContent())
	{
		ResponseDTO response=mapToEmployeeResponseDTO(employee);
		employeeList.add(response);
	}
	
	return employeeList;
}	
	
	
	
	
	
	
	
	
	
	
	
	
	

//#############################################################################################################	
	// Mapper Methods below
//#############################################################################################################	
	
//Method- by @Rohit -Mapper method RequestDTO-->Employee Entity-[12/3/26]
	public  EmployeeEntity mapToEmployeeEntity(RequestDTO request)
	{
		EmployeeEntity Employee=new EmployeeEntity();
		
		Employee.setEmpEmail(request.getReq_empEmail());
		Employee.setEmpName(request.getReq_empName());
		Employee.setSalary(request.getReq_salary());
		//Employee.setDepartment(request.getReq_department());  --> Depricated this method
		
		AddressEntity address=mapToAddressEntity(request.getReq_address());
		Employee.setAddress(address);
//---------------------------------------------------------------------------------------------------
//	     Department Mapping
//---------------------------------------------------------------------------------------------------

		DepartmentEntity department =mapToDepartmentEntity(request);
		        
		Employee.setDepartment(department);
//---------------------------------------------------------------------------------------------------
//     Project Mapping
//---------------------------------------------------------------------------------------------------
		
		List<ProjectEntity> projectList=mapToProjectsList(request);
		Employee.setProjects(projectList);
		projectList.forEach(p->p.setEmployees(List.of(Employee)));
		
		return Employee;
	}
	
	//Method- by @Rohit -Mapper method Employee-->ResponseDTO Entity -[12/3/26]
	public static ResponseDTO mapToEmployeeResponseDTO(EmployeeEntity employee)
	{
		ResponseDTO response=new ResponseDTO();
		response.setRes_empID(employee.getEmpID());
    	response.setRes_empName(employee.getEmpName());
    	response.setRes_department(employee.getDepartment().getDepartmentName());   //hidden for short term
    	response.setRes_empEmail(employee.getEmpEmail());
    	response.setRes_salary(employee.getSalary());
    	response.setRes_EmployeeCity(employee.getAddress().getCity());
    	response.setRes_projects(employee.getProjects().stream().map(ProjectEntity->ProjectEntity.getProjectName()).toList());
    	
    	return response;
	}
	
//######################################################################################################
	// Address Entity Mapping methods
//######################################################################################################	
	
	//Method- by @Rohit -Mapper method AddressRequestDTO-->AddressEntity -[12/3/26]
	public  AddressEntity mapToAddressEntity(AddressRequestDTO addRequestDTO)
		{
			AddressEntity addressEntity=new AddressEntity();
			addressEntity.setCity(addRequestDTO.getReq_city());
			addressEntity.setState(addRequestDTO.getReq_state());
			addressEntity.setPincode(addRequestDTO.getReq_pincode());
			
			return addressEntity;
		}

//######################################################################################################
		// Department Entity Mapping methods
//######################################################################################################	
	//Method- by @Rohit -Mapper method DepartmentRequestDTO-->DepartmentEntity Entity -[12/3/26]
	
	public  DepartmentEntity mapToDepartmentEntity(RequestDTO request)
	{
		DepartmentEntity  department=deptRepo.findByDepartmentName(request.getReq_department().getReq_departmentName())
		  .orElseGet(()->{
			  DepartmentEntity newDepartment=new DepartmentEntity();
			  newDepartment.setDepartmentName(request.getReq_department().getReq_departmentName());
			  newDepartment.setDepartmentLocation(request.getReq_department().getReq_departmentLocation());
			  return  deptRepo.save(newDepartment) ;
		  });
		        	
		       
		
		return department;
		
		
	}
	
//######################################################################################################
			// Project Entity Mapping methods
//######################################################################################################	
		//Method- by @Rohit -Mapper method ProjectRequestDTO-->Project Entity -[17/3/26]

	public List<ProjectEntity> mapToProjectsList(RequestDTO request)
	{
	    return request.getReq_projects().stream()
	            .map(projectDTO -> {

	                ProjectEntity project = projectRepo
	                        .findByProjectName(projectDTO.getProjectName()) // or custom finder
	                        .orElseGet(() -> {
	                            ProjectEntity newProject = new ProjectEntity();
	                            newProject.setProjectName(projectDTO.getProjectName());
	                            newProject.setBudget(projectDTO.getBudget());
	                            return projectRepo.save(newProject);
	                        });

	                return project;
	            })
	            .toList();
	}
	
	
	
	
	
	
	
	
	
}
