package com.example.SprinBooot_JPA_demo.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SprinBooot_JPA_demo.DTO.AddressRequestDTO;
import com.example.SprinBooot_JPA_demo.DTO.DepartmentRequestDTO;
import com.example.SprinBooot_JPA_demo.DTO.RequestDTO;
import com.example.SprinBooot_JPA_demo.DTO.ResponseDTO;
import com.example.SprinBooot_JPA_demo.Entity.AddressEntity;
import com.example.SprinBooot_JPA_demo.Entity.DepartmentEntity;
import com.example.SprinBooot_JPA_demo.Entity.EmployeeEntity;
import com.example.SprinBooot_JPA_demo.Repo.AddressRepo;
import com.example.SprinBooot_JPA_demo.Repo.DepartmentRepo;
import com.example.SprinBooot_JPA_demo.Repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepo empRepo;
	
	@Autowired
	DepartmentRepo deptRepo;
	
	@Autowired
	AddressRepo addRepo;
	
	@Override
	public EmployeeEntity getEmployee(Long empId) {
		
		return empRepo.findById(empId).orElseThrow();
		
	}

	@Override
	public String createEmployee(RequestDTO requestDTO) {
//--------------Following Part - Before mapper method [mapToEmployeeEntity] -------------------------		
//		EmployeeEntity request=new EmployeeEntity();
//		request.setDepartment(requestDTO.getReq_department());
//		request.setEmpEmail(requestDTO.getReq_empEmail());
//		request.setEmpName(requestDTO.getReq_empName());
//		request.setSalary(requestDTO.getReq_salary());		
		//REMOVED [Id creation takes care by JPA]request.setEmpID(request.getEmpID());
//----------------------------------------------------------------------------------------------------		
		//Start-Adding address one:one by @Rohit -[12/03/2026]
		
		EmployeeEntity request= mapToEmployeeEntity(requestDTO);
		
//		AddressEntity address=new AddressEntity();
//		//REMOVED [Id creation takes care by JPA]-address.setAddress_Id(address.getAddress_Id());
//		address.setCity(requestDTO.getReq_address().getCity());
//		address.setPincode(requestDTO.getReq_address().getPincode());
//		address.setState(requestDTO.getReq_address().getState());
//		
		
		empRepo.save(request);
		
		//End-Adding address one:one by @Rohit -[12/03/2026]
		
		return "UserCreated Succeefully";
	}

	@Override
	public EmployeeEntity updateEmployee(RequestDTO requestDTO) {

//--------------Following Part - Before mapper method [mapToEmployeeEntity] -------------------------		
//		EmployeeEntity request=new EmployeeEntity();
//		request.setDepartment(requestDTO.getReq_department());
//		request.setEmpEmail(requestDTO.getReq_empEmail());
//		request.setEmpName(requestDTO.getReq_empName());
//		request.setSalary(requestDTO.getReq_salary());
//		//request.setEmpID(request.getEmpID());
//------------------------------------------------------------------------------------------------------		
		EmployeeEntity request=mapToEmployeeEntity(requestDTO);
		return empRepo.save(request);
		
	}
	
	
	@Override
	public String createListOfEmployee(RequestDTO[] requestDTOArray) {
	  
		List<Long> empIdList=new ArrayList<>();
	   
		for(RequestDTO requestDTO:requestDTOArray)
		{
//--------------Following Part - Before mapper method [mapToEmployeeEntity] -------------------------
//			EmployeeEntity request=new EmployeeEntity();
//			
//			request.setDepartment(requestDTO.getReq_department());
//			request.setEmpEmail(requestDTO.getReq_empEmail());
//			request.setEmpName(requestDTO.getReq_empName());
//			request.setSalary(requestDTO.getReq_salary());
//---------------------------------------------------------------------------------------------------
			
			EmployeeEntity request=	mapToEmployeeEntity(requestDTO);
			
			//Address Entity mapping
			
//--------------Following Part - Before mapper method [mapToAddressEntity] -------------------------			
//			address.setCity(requestDTO.getReq_address().getCity());
//			address.setPincode(requestDTO.getReq_address().getPincode());
//			address.setState(requestDTO.getReq_address().getState());
//--------------------------------------------------------------------------------------------------			
//			AddressEntity address=mapToAddressEntity(requestDTO.getReq_address());
//			request.setAddress(address);
			
			empRepo.save(request);
			empIdList.add(request.getEmpID());
			
		}
		
		return "All users saved : "+empIdList;
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
//--------------Following Part - Before mapper method [mapToEmployeeResponseDTO] -------------------------	    	
//	    	ResponseDTO response = new ResponseDTO();
// 	     	response.setRes_empID(employee.getEmpID());
//	    	response.setRes_empName(employee.getEmpName());
//	    	response.setRes_department(employee.getDepartment());
//	    	response.setRes_empEmail(employee.getEmpEmail());
//	    	response.setRes_salary(employee.getSalary());
//--------------------------------------------------------------------------------------------------
	    	ResponseDTO response = mapToEmployeeResponseDTO(employee);
	    	
	    	resposeList.add(response);
	    }
	   
	    
	    return resposeList;
		
	}

	
	
	
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
		
//		DepartmentEntity department=mapToDepartmentEntity(request.getReq_department());
//		Employee.setDepartment(department);
 
		DepartmentEntity department =
		        deptRepo.findById(request.getReq_department().getReq_departmentName())
		        .orElseGet(() -> mapToDepartmentEntity(request.getReq_department()));
		Employee.setDepartment(department);
		
		return Employee;
	}
	
	//Method- by @Rohit -Mapper method Employee-->ResponseDTO Entity -[12/3/26]
	public static ResponseDTO mapToEmployeeResponseDTO(EmployeeEntity employee)
	{
		ResponseDTO response=new ResponseDTO();
		//response.setRes_empID(employee.getEmpID());
    	response.setRes_empName(employee.getEmpName());
    	//response.setRes_department(employee.getDepartment);   hidden for short term
    	response.setRes_empEmail(employee.getEmpEmail());
    	response.setRes_salary(employee.getSalary());
    	
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
	//Method- by @Rohit -Mapper method Employee-->ResponseDTO Entity -[12/3/26]
	
	public  DepartmentEntity mapToDepartmentEntity(DepartmentRequestDTO deptRequestDTO)
	{
		DepartmentEntity department=new DepartmentEntity();
		department.setDepartmentName(deptRequestDTO.getReq_departmentName());
		department.setDepartmentLocation(deptRequestDTO.getReq_departmentLocation());
		
		return department;
		
		
	}
	
}
