package com.alpha.employeeManagement.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {
	
	@jakarta.persistence.Id
	private int id ;
	
	private String name;
	private int age;
   
	private int mobileno;
	@Email(message = "Enter rght format")
	private String gmail;
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", mobileno=" + mobileno + ", gmail=" + gmail
				+ ", role=" + role + ", salary=" + salary + "]";
	}
	public Employee() {
		super();
	}
	public Employee(int id, String name, int age,   int mobileno, String gmail, String role, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.mobileno = mobileno;
		this.gmail = gmail;
		this.role = role;
		this.salary = salary;
	}
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
	public   int getMobileno() {
		return mobileno;
	}
	public void setMobileno( int mobileno) {
		this.mobileno = mobileno;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	private String role;
	private double salary;

}
