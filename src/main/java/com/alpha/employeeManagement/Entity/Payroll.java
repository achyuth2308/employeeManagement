package com.alpha.employeeManagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payrollId;

    private String month;
    private int year;

    private double perDaySalary;
    private int daysWorked;

    private double basicSalary;
    private double hra;
    private double pf;
    private double bonus;
    private double deductions;

    private double grossSalary;
    private double netSalary;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

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

	public double getPerDaySalary() {
		return perDaySalary;
	}

	public void setPerDaySalary(double perDaySalary) {
		this.perDaySalary = perDaySalary;
	}

	public int getDaysWorked() {
		return daysWorked;
	}

	public void setDaysWorked(int daysWorked) {
		this.daysWorked = daysWorked;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getPf() {
		return pf;
	}

	public void setPf(double pf) {
		this.pf = pf;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getDeductions() {
		return deductions;
	}

	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	

	public int getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
	}

	public Payroll(String month, int year, double perDaySalary, int daysWorked, double basicSalary, double hra, double pf,
			double bonus, double deductions, double grossSalary, double netSalary, Employee employee) {
		super();
		this.month = month;
		this.year = year;
		this.perDaySalary = perDaySalary;
		this.daysWorked = daysWorked;
		this.basicSalary = basicSalary;
		this.hra = hra;
		this.pf = pf;
		this.bonus = bonus;
		this.deductions = deductions;
		this.grossSalary = grossSalary;
		this.netSalary = netSalary;
		this.employee = employee;
	}

	public Payroll() {
		super();
	}

	@Override
	public String toString() {
		return "Payroll [payrollId=" + payrollId + ", month=" + month + ", year=" + year + ", perDaySalary="
				+ perDaySalary + ", daysWorked=" + daysWorked + ", basicSalary=" + basicSalary + ", hra=" + hra
				+ ", pf=" + pf + ", bonus=" + bonus + ", deductions=" + deductions + ", grossSalary=" + grossSalary
				+ ", netSalary=" + netSalary + ", employee=" + employee + "]";
	}
	
	
    
    
}
