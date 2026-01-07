package com.alpha.employeeManagement.DTO;

import java.util.List;

import com.alpha.employeeManagement.Entity.Payroll;

public class AnnualSalaryDTO {

	private int year;
    private double totalGrossSalary;
    private double totalDeductions;
    private double totalNetSalary;
//    private List<Payroll> monthlyPayrolls;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getTotalGrossSalary() {
		return totalGrossSalary;
	}
	public void setTotalGrossSalary(double totalGrossSalary) {
		this.totalGrossSalary = totalGrossSalary;
	}
	public double getTotalDeductions() {
		return totalDeductions;
	}
	public void setTotalDeductions(double totalDeductions) {
		this.totalDeductions = totalDeductions;
	}
	public double getTotalNetSalary() {
		return totalNetSalary;
	}
	public void setTotalNetSalary(double totalNetSalary) {
		this.totalNetSalary = totalNetSalary;
	}
//	public List<Payroll> getMonthlyPayrolls() {
//		return monthlyPayrolls;
//	}
//	public void setMonthlyPayrolls(List<Payroll> monthlyPayrolls) {
//		this.monthlyPayrolls = monthlyPayrolls;
//	}
	public AnnualSalaryDTO(int year, double totalGrossSalary, double totalDeductions, double totalNetSalary,
			List<Payroll> monthlyPayrolls) {
		super();
		this.year = year;
		this.totalGrossSalary = totalGrossSalary;
		this.totalDeductions = totalDeductions;
		this.totalNetSalary = totalNetSalary;
//		this.monthlyPayrolls = monthlyPayrolls;
	}
	public AnnualSalaryDTO() {
		super();
	}
	@Override
	public String toString() {
		return "AnnualSalaryDTO [year=" + year + ", totalGrossSalary=" + totalGrossSalary + ", totalDeductions="
				+ totalDeductions + ", totalNetSalary=" + totalNetSalary +"]";
	}
    
    
}
