package com.alpha.employeeManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.employeeManagement.Service.PayslipPdfService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class PaySlipPDFController {

    @Autowired
    private PayslipPdfService payslipPdfService;

    @GetMapping("/payslip/pdf/{employeeId}/{month}/{year}")
    public void downloadPayslip(
            @PathVariable("employeeId") int employeeId,
            @PathVariable String month,
            @PathVariable int year,
            HttpServletResponse response) throws Exception {

        response.setContentType("application/pdf");
        response.setHeader(
                "Content-Disposition",
                "attachment; filename=payslip_" + employeeId + "_" + month + "_" + year + ".pdf"
        );

        payslipPdfService.generatePayslipPdf(employeeId, month, year, response);
    }
}
