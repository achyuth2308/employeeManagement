package com.alpha.employeeManagement.DTO;

public class PayrollResponseDTO {

    private int employeeId;
    private String employeeName;
    private String role;

    private String bankName;
    private String ifscCode;

    // PF Details
    private String pfUanNumber;
    private String pfHolderName;

    private String month;
    private int year;

    private double perDaySalary;
    private int daysWorked;

    private double basicSalary;
    private double hra;
    private double pf;
    private double bonus;
    private double grossSalary;
    private double deductions;
    private double netSalary;

    // Getters and Setters
    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }

    public String getIfscCode() { return ifscCode; }
    public void setIfscCode(String ifscCode) { this.ifscCode = ifscCode; }

    public String getPfUanNumber() { return pfUanNumber; }
    public void setPfUanNumber(String pfUanNumber) { this.pfUanNumber = pfUanNumber; }

    public String getPfHolderName() { return pfHolderName; }
    public void setPfHolderName(String pfHolderName) { this.pfHolderName = pfHolderName; }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getPerDaySalary() { return perDaySalary; }
    public void setPerDaySalary(double perDaySalary) { this.perDaySalary = perDaySalary; }

    public int getDaysWorked() { return daysWorked; }
    public void setDaysWorked(int daysWorked) { this.daysWorked = daysWorked; }

    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }

    public double getHra() { return hra; }
    public void setHra(double hra) { this.hra = hra; }

    public double getPf() { return pf; }
    public void setPf(double pf) { this.pf = pf; }

    public double getBonus() { return bonus; }
    public void setBonus(double bonus) { this.bonus = bonus; }

    public double getGrossSalary() { return grossSalary; }
    public void setGrossSalary(double grossSalary) { this.grossSalary = grossSalary; }

    public double getDeductions() { return deductions; }
    public void setDeductions(double deductions) { this.deductions = deductions; }

    public double getNetSalary() { return netSalary; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }

    // Constructors
    public PayrollResponseDTO() {
        super();
    }

    public PayrollResponseDTO(int employeeId, String employeeName, String role, String bankName, String ifscCode,
                              String pfUanNumber, String pfHolderName, String month, int year, double perDaySalary,
                              int daysWorked, double basicSalary, double hra, double pf, double bonus, double grossSalary,
                              double deductions, double netSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.role = role;
        this.bankName = bankName;
        this.ifscCode = ifscCode;
        this.pfUanNumber = pfUanNumber;
        this.pfHolderName = pfHolderName;
        this.month = month;
        this.year = year;
        this.perDaySalary = perDaySalary;
        this.daysWorked = daysWorked;
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.pf = pf;
        this.bonus = bonus;
        this.grossSalary = grossSalary;
        this.deductions = deductions;
        this.netSalary = netSalary;
    }

    @Override
    public String toString() {
        return "PayrollResponseDTO [employeeId=" + employeeId + ", employeeName=" + employeeName + ", role=" + role
                + ", bankName=" + bankName + ", ifscCode=" + ifscCode + ", pfUanNumber=" + pfUanNumber
                + ", pfHolderName=" + pfHolderName + ", month=" + month + ", year=" + year + ", perDaySalary="
                + perDaySalary + ", daysWorked=" + daysWorked + ", basicSalary=" + basicSalary + ", hra=" + hra
                + ", pf=" + pf + ", bonus=" + bonus + ", grossSalary=" + grossSalary + ", deductions=" + deductions
                + ", netSalary=" + netSalary + "]";
    }
}
