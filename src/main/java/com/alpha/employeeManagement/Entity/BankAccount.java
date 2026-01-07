package com.alpha.employeeManagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @NotNull(message = "Bank name cannot be null")
    @Pattern(
        regexp = "^[A-Za-z ]{3,50}$",
        message = "Bank name must contain only letters and spaces (min 3 characters)"
    )
    private String bankName;

    @Column(unique = true, nullable = false, length = 16)
    @NotNull(message = "Account number cannot be null")
    @Pattern(
        regexp = "^[0-9]{12,16}$",
        message = "Account number must be 12 to 16 digits only"
    )
    private String accountNumber;

    @NotNull(message = "IFSC code cannot be null")
    @Pattern(
        regexp = "^[A-Z]{4}0[A-Z0-9]{6}$",
        message = "Invalid IFSC code format (Example: SBIN0001234)"
    )
    private String ifscCode;

    @NotNull(message = "Branch cannot be null")
    @Pattern(
        regexp = "^[A-Za-z0-9 ]{3,50}$",
        message = "Branch name must be at least 3 characters"
    )
    private String branch;

    @OneToOne
    @JoinColumn(name = "employee_id", unique = true, nullable = false)
    private Employee employee;
    
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public BankAccount(String bankName, String accountNumber, String ifscCode, String branch, Employee employee) {
		super();
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.branch = branch;
		this.employee = employee;
	}

	public BankAccount() {
		super();
	}

	@Override
	public String toString() {
		return "BankAccount [accountId=" + accountId + ", bankName=" + bankName + ", accountNumber=" + accountNumber
				+ ", ifscCode=" + ifscCode + ", branch=" + branch + ", employee=" + employee + "]";
	}
    
    
}

