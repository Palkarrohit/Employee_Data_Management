package com.example.SprinBooot_JPA_demo.ServiceTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.SprinBooot_JPA_demo.DTO.AddressRequestDTO;
import com.example.SprinBooot_JPA_demo.DTO.DepartmentRequestDTO;
import com.example.SprinBooot_JPA_demo.DTO.ProjectRequestDTO;
import com.example.SprinBooot_JPA_demo.DTO.RequestDTO;
import com.example.SprinBooot_JPA_demo.DTO.ResponseDTO;
import com.example.SprinBooot_JPA_demo.Entity.AddressEntity;
import com.example.SprinBooot_JPA_demo.Entity.DepartmentEntity;
import com.example.SprinBooot_JPA_demo.Entity.EmployeeEntity;
import com.example.SprinBooot_JPA_demo.Repo.AddressRepo;
import com.example.SprinBooot_JPA_demo.Repo.DepartmentRepo;
import com.example.SprinBooot_JPA_demo.Repo.EmployeeRepo;
import com.example.SprinBooot_JPA_demo.Repo.ProjectRepo;
import com.example.SprinBooot_JPA_demo.Service.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
	@Mock
    private EmployeeRepo empRepo;

    @Mock
    private DepartmentRepo deptRepo;

    @Mock
    private AddressRepo addRepo;

    @Mock
    private ProjectRepo projectRepo;
    
    @InjectMocks
    private EmployeeServiceImpl employeeService;
//========================================= Unit testCases ===================================================================    
    
  
    //test1
    @Test
    public void testGetEmployee_Success()
    {
    	//setting mock values
    	EmployeeEntity emp= new EmployeeEntity();
    	emp.setEmpID(1L);
    	emp.setEmpName("Rohit");
        emp.setEmpEmail("rohit@gmail.com");
        
        AddressEntity address = new AddressEntity();
        address.setCity("Nagpur");
        emp.setAddress(address);
        
        DepartmentEntity dept = new DepartmentEntity();
        dept.setDepartmentName("IT");
        emp.setDepartment(dept);
        
        emp.setProjects(List.of());
        
        when(empRepo.findById(1L)).thenReturn(Optional.of(emp));
        
        //when  condition
        ResponseDTO response = employeeService.getEmployee(1L);
        
        // THEN
        assertEquals("Rohit", response.getRes_empName());
        verify(empRepo, times(1)).findById(1L);

    	
    }
    
    //test 2
//    @Test
//    void testCreateEmployee() {
//
//        RequestDTO request = new RequestDTO();
//        request.setReq_empName("Rohit");
//        request.setReq_empEmail("rohit@gmail.com");
//        request.setReq_salary(50000);
//        
//        AddressRequestDTO address = new AddressRequestDTO();
//        address.setReq_city("Nagpur");
//        address.setReq_state("MH");
//        address.setReq_pincode(440001L);
//        request.setReq_address(address);
//        
//        // ✅ FIX: Add Department
//        DepartmentRequestDTO dept = new DepartmentRequestDTO();
//        dept.setReq_departmentName("IT");
//        dept.setReq_departmentLocation("Pune");
//        request.setReq_department(dept);
//
//        // ✅ FIX: Add Projects (VERY IMPORTANT)
//        ProjectRequestDTO project = new ProjectRequestDTO();
//        project.setProjectName("ProjectX");
//        project.setBudget(10000L);
//
//        when(deptRepo.findByDepartmentName(anyString()))
//                .thenReturn(Optional.empty());
//
//        when(deptRepo.save(any())).thenAnswer(i -> i.getArgument(0));
//
//        when(projectRepo.findByProjectName(anyString()))
//                .thenReturn(Optional.empty());
//
//        when(projectRepo.save(any())).thenAnswer(i -> i.getArgument(0));
//
//        when(empRepo.save(any())).thenAnswer(i -> i.getArgument(0));
//
//        String result = employeeService.createEmployee(request);
//
//        assertTrue(result.contains("UserCreated"));
//        verify(empRepo, times(1)).save(any());
//    }
//    
//    
    
    //test 3
    @Test
    void testDeleteEmployee() {

        EmployeeEntity emp = new EmployeeEntity();
        emp.setEmpID(1L);

        when(empRepo.findById(1L)).thenReturn(Optional.of(emp));

        String result = employeeService.deleteEmployee(1L);

        assertEquals("Employee Deleted : 1", result);
        verify(empRepo).delete(emp);
    }
    
    //test 4
    @Test
    void testGetEmployeeWithPagination() {

        EmployeeEntity emp = new EmployeeEntity();
        emp.setEmpID(1L);
        emp.setEmpName("Rohit");

        AddressEntity address = new AddressEntity();
        address.setCity("Nagpur");
        emp.setAddress(address);

        DepartmentEntity dept = new DepartmentEntity();
        dept.setDepartmentName("IT");
        emp.setDepartment(dept);
        
        ProjectRequestDTO project = new ProjectRequestDTO();
        
        project.setProjectName("ProjectX");

        emp.setProjects(List.of());

        Page<EmployeeEntity> page =
                new PageImpl<>(List.of(emp));

        when(empRepo.findAll(any(Pageable.class))).thenReturn(page);

        List<ResponseDTO> result =
                employeeService.getEmployeeWithPagination(0, 10);

        assertEquals(1, result.size());
    }

}
