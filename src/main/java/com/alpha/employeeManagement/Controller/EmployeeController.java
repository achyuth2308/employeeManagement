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
import com.alpha.employeeManagement.Entity.Employee;
import com.alpha.employeeManagement.Service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService es;
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee( @RequestBody Employee employee) {
        return es.saveEmp(employee);
 
	}
	@GetMapping("/findEmployee")
	public ResponseEntity<ResponseStructure<Employee>> findEmployee( @RequestParam int id){
		return es.findById(id);
		
	}
	
	@PutMapping("/updateemploye")
	public ResponseEntity<ResponseStructure<Employee>> updateemployee(@RequestParam int id ,@RequestParam String role , @RequestParam double salary){
		
		return es.updateemployee(id,role,salary);
		
	}
	
	@DeleteMapping("/deleteemployee")
	public ResponseEntity<ResponseStructure<Employee>> deleteemployee(@RequestParam int id){
		
		return es.deleteemployee(id);
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> seeAllEmployees(){
		return es.getAllEmployees();
	}
	
}
