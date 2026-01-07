package com.alpha.employeeManagement.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class EmployeeDTO{

	private String name;
	private int age;
	private String role;
	private int salary;
	
	@Size(min = 10, max = 10, message = "Enter proper mobile number")
	private String mobileno;
	
	@Email(message = "Entered email is not valid")
	private String email;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EmployeeDTO(String name, int age, String role, int salary, @Size(min = 10, max = 10, message = "Enter proper mobile number") String mobileno, String email) {
		super();
		this.name = name;
		this.age = age;
		this.role = role;
		this.salary = salary;
		this.mobileno = mobileno;
		this.email = email;
	}
	public EmployeeDTO() {
		super();
	}
	@Override
	public String toString() {
		return "EmployeeDTO [name=" + name + ", age=" + age + ", role=" + role + ", salary=" + salary
				+ ", mobileno=" + mobileno + ", email=" + email + "]";
	}
	
	
}
 

