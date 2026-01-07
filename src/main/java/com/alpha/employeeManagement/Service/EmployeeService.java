package com.alpha.employeeManagement.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.alpha.employeeManagement.ResponseStructure;
import com.alpha.employeeManagement.DTO.EmployeeDTO;
import com.alpha.employeeManagement.Entity.Employee;
import com.alpha.employeeManagement.Repository.EmployeeRepository;

import jakarta.transaction.Transactional; 
import jakarta.validation.Valid;
@Service public class EmployeeService { 
	
	@Autowired 
	private EmployeeRepository employeerepository;
	
	//Registering employee 
	
	public ResponseEntity<ResponseStructure<Employee>> RegisterEmployeeDTO(EmployeeDTO employeeDTO) {
	
	Employee employee = new Employee();
	
	employee.setName(employeeDTO.getName());
	employee.setAge(employeeDTO.getAge());
	employee.setRole(employeeDTO.getRole());
	employee.setSalary(employeeDTO.getSalary());
	employee.setMobileno(employeeDTO.getMobileno());
	employee.setEmail(employeeDTO.getEmail());
	employeerepository.save(employee);
	
	ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
		responseStructure.setStatuscode(HttpStatus.OK.value()); responseStructure.setMessage("Empployee Registered Sucessfully");
		responseStructure.setData(employee); return ResponseEntity.ok(responseStructure); 
	}
	
	//Finding Employee 
	
	public ResponseEntity<ResponseStructure<Employee>> findEmployee(int id) {
		
		Employee e = employeerepository.findById(id);
		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Employee with id "+id+" found");
		responseStructure.setData(e); return ResponseEntity.ok(responseStructure);
	} 
	
	//Updating employee 
	
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(int id, int salary) {
		
		Employee e = employeerepository.findById(id);
		e.setSalary(salary); employeerepository.save(e);
		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Salary Updated");
		responseStructure.setData(e);
		return ResponseEntity.ok(responseStructure);
	}
	
	//Deleting Employee 
	
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(int id) {
		
		Employee e = employeerepository.deleteById(id);
		employeerepository.save(e);
		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setMessage("Employee Deleted sucessfully");
		return ResponseEntity.ok(responseStructure); 
	}
	
	//getAllEmployee
	
	public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmployee() {
		
		List<Employee> e = employeerepository.findAll();
		ResponseStructure<List<Employee>> responseStructure = new ResponseStructure<List<Employee>>(); 
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setMessage("All Employee Details");
		responseStructure.setData(e);
		return ResponseEntity.ok(responseStructure); 
	} 
}
