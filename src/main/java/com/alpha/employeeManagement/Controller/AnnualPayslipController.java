package com.alpha.employeeManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.alpha.employeeManagement.Service.AnnualPayslipPdfService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/annual-payslip")
public class AnnualPayslipController {

    @Autowired
    private AnnualPayslipPdfService annualPayslipPdfService;

    @GetMapping("/pdf/{id}")
    public void generateAnnualPayslip(@PathVariable int id,@RequestParam int year,HttpServletResponse response) throws Exception {

        annualPayslipPdfService.generateAnnualPayslipPdf(id, year, response);
    }
}
