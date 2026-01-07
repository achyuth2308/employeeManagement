package com.alpha.employeeManagement.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alpha.employeeManagement.ResponseStructure;
import com.alpha.employeeManagement.DTO.EmployeeDTO;
import com.alpha.employeeManagement.Entity.Employee;
import com.alpha.employeeManagement.Service.EmployeeService;

import jakarta.validation.Valid;
@RestController 
public class EmployeeController {
	
	@Autowired private EmployeeService employeeservice;
	
	@PostMapping("/registerEmployee") 
	public ResponseEntity<ResponseStructure<Employee>> RegisterEmployeeDTO(@Valid @RequestBody EmployeeDTO employeeDTO) {
			return employeeservice.RegisterEmployeeDTO(employeeDTO);
	}
	
	@GetMapping("/findEmployee") 
	public ResponseEntity<ResponseStructure<Employee>> findEmployee(@RequestParam int id) {
			return employeeservice.findEmployee(id); 
	}
	
	@PutMapping("/updateEmployee") 
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestParam int id , @RequestParam int salary) { 
			return employeeservice.updateEmployee(id ,salary);
	}
	
	@DeleteMapping("/deleteEmployee") 
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@RequestParam int id) { return employeeservice.deleteEmployee(id);
	}
	
	@GetMapping("/getAllEmployee")
	public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmployee() {
		return employeeservice.getAllEmployee();
	}
	
	
}