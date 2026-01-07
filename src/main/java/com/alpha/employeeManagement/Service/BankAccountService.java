package com.alpha.employeeManagement.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.employeeManagement.AccountNumberGenerator;
import com.alpha.employeeManagement.Entity.BankAccount;
import com.alpha.employeeManagement.Entity.Employee;
import com.alpha.employeeManagement.Repository.BankAccountRepository;
import com.alpha.employeeManagement.Repository.EmployeeRepository;

@Service
public class BankAccountService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public BankAccount assignBankAccount(int id, BankAccount bankAccount) {

    	Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));

        if (bankAccountRepository.findById(id).isPresent()) {
            throw new RuntimeException("Employee already has a bank account");
        }

        bankAccount.setAccountNumber(AccountNumberGenerator.generateAccountNumber());

        bankAccount.setEmployee(employee);

        return bankAccountRepository.save(bankAccount);
    }
}

