package com.alpha.employeeManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.employeeManagement.DTO.AnnualSalaryDTO;
import com.alpha.employeeManagement.DTO.PayrollResponseDTO;
import com.alpha.employeeManagement.Entity.Payroll;
import com.alpha.employeeManagement.Service.PayrollService;
import com.alpha.employeeManagement.Service.PayslipPdfService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/payroll")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @GetMapping("/generate")
    public ResponseEntity<PayrollResponseDTO> generatePayroll(@RequestParam int id,@RequestParam String month,@RequestParam int year) {

        return ResponseEntity.ok(payrollService.generatePayroll(id, month, year));
    }
    
    @GetMapping("/annualSalary")
    public ResponseEntity<AnnualSalaryDTO> annualSalary(@RequestParam int id,@RequestParam int year) {

        return ResponseEntity.ok(payrollService.annualSalary(id,year));
    }
    
    

    
}

