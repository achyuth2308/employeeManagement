package com.alpha.employeeManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.employeeManagement.Entity.BankAccount;
import com.alpha.employeeManagement.Service.BankAccountService;

@RestController
public class BankAccountController {

	@Autowired
	private BankAccountService bankaccountservice;
	
	@PostMapping("/assigningBankAccount")
	public ResponseEntity<BankAccount> assignBankAccount(@RequestParam int id , @RequestBody BankAccount bankAccount) {
		
		
		return ResponseEntity.ok(bankaccountservice.assignBankAccount(id, bankAccount));
	}
}
