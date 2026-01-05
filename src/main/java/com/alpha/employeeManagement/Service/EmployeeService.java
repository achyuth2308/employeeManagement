package com.alpha.employeeManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.employeeManagement.ResponseStructure;
import com.alpha.employeeManagement.Entity.Employee;
import com.alpha.employeeManagement.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;

	public ResponseEntity<ResponseStructure<Employee>> saveEmp(Employee employee) {
		
		Employee emp = employeeRepo.save(employee);
		
		ResponseStructure<Employee> rs = new ResponseStructure<>();
        rs.setStatuscode(200);
        rs.setMessage("Employee saved successfully");
        rs.setData(emp);

        return ResponseEntity.ok(rs);
		
	}

	public ResponseEntity<ResponseStructure<Employee>> findById(int id) {
		Employee emp =  employeeRepo.findById(id);
		
		ResponseStructure<Employee> rs = new ResponseStructure<>();
        rs.setStatuscode(200);
        rs.setMessage("Employee fetched successfully");
        rs.setData(emp);

        return ResponseEntity.ok(rs);
	}

	public ResponseEntity<ResponseStructure<Employee>> updateemployee(int id, String role, double salary) {
		
		Employee emp = employeeRepo.findById(id);
		emp.setRole(role);
		emp.setSalary(salary);
        employeeRepo.save(emp);
		
		ResponseStructure<Employee> rs = new ResponseStructure<>();
        rs.setStatuscode(200);
        rs.setMessage("Employee updated successfully");
        rs.setData(emp);

        return ResponseEntity.ok(rs);
		
	}

	public ResponseEntity<ResponseStructure<Employee>> deleteemployee(int id) {
		
		Employee emp = employeeRepo.deleteById(id);
		employeeRepo.save(emp);
		
		ResponseStructure<Employee> rs = new ResponseStructure<>();
        rs.setStatuscode(200);
        rs.setMessage("Employee deleted successfully");
        

        return ResponseEntity.ok(rs);
		
		
	}

	public List getAllEmployees() {
		List<Employee> emp = employeeRepo.findAll();
//		ResponseStructure<list<Employee>> rs = new ResponseStructure<>();
//        rs.setStatuscode(200);
//        rs.setMessage(" all Employees fetched successfully");
//        rs.setData(emp);
//        
//
//        return ResponseEntity.ok(rs);
		return emp;
	}



	
	
	

}
