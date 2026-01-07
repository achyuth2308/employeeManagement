package com.alpha.employeeManagement.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String role;
	private int salary;
	private String mobileno;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Employee(String name, int age, String role, int salary, String mobileno, String email) {
		super();
		this.name = name;
		this.age = age;
		this.role = role;
		this.salary = salary;
		this.mobileno = mobileno;
		this.email = email;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", role=" + role + ", salary=" + salary
				+ ", mobileno=" + mobileno + ", email=" + email + "]";
	}
	
	
	
	
}
