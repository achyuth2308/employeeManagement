package com.alpha.employeeManagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int attendanceId;
	private String month;
	private int year;
	private int totalWorkingDays;
	private int workingdays;
	private int leaves;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getTotalWorkingDays() {
		return totalWorkingDays;
	}

	public void setTotalWorkingDays(int totalWorkingDays) {
		this.totalWorkingDays = totalWorkingDays;
	}

	public int getWorkingdays() {
		return workingdays;
	}

	public void setWorkingdays(int workingdays) {
		this.workingdays = workingdays;
	}

	public int getLeaves() {
		return leaves;
	}

	public void setLeaves(int leaves) {
		this.leaves = leaves;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Attendance(String month, int year, int totalWorkingDays, int workingdays, int leaves, Employee employee) {
		super();
		this.month = month;
		this.year = year;
		this.totalWorkingDays = totalWorkingDays;
		this.workingdays = workingdays;
		this.leaves = leaves;
		this.employee = employee;
	}

	public Attendance() {
		super();
	}

	@Override
	public String toString() {
		return "Attendance [attendanceId=" + attendanceId + ", month=" + month + ", year=" + year
				+ ", totalWorkingDays=" + totalWorkingDays + ", workingdays=" + workingdays + ", leaves=" + leaves
				+ ", employee=" + employee + "]";
	}

	
	
	
}
