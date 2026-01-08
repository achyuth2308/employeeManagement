package com.alpha.employeeManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alpha.employeeManagement.DTO.AnnualSalaryDTO;
import com.alpha.employeeManagement.Service.AnnualSalaryService;

@RestController
@RequestMapping("/api/annual-salary")
public class AnnualSalaryController {

    @Autowired
    private AnnualSalaryService annualSalaryService;

    /**
     * Get Annual Salary Summary (JSON response)
     * Example:
     * GET /api/annual-salary/employee/1?year=2025
     */
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<?> getAnnualSalary(
            @PathVariable int employeeId,
            @RequestParam int year) {

        try {
            AnnualSalaryDTO annualSalary =
                    annualSalaryService.calculateAnnualSalary(employeeId, year);

            return ResponseEntity.ok(annualSalary);

        } catch (RuntimeException ex) {
            return ResponseEntity
                    .badRequest()
                    .body(ex.getMessage());
        }
    }
}
