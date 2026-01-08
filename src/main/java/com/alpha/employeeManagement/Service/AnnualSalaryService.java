package com.alpha.employeeManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.employeeManagement.DTO.AnnualSalaryDTO;
import com.alpha.employeeManagement.Entity.Payroll;
import com.alpha.employeeManagement.Repository.PayrollRepository;

@Service
public class AnnualSalaryService {

    @Autowired
    private PayrollRepository payrollRepository;

    public AnnualSalaryDTO calculateAnnualSalary(int employeeId, int year) {

        List<Payroll> payrolls =
                payrollRepository.findByEmployee_IdAndYear(employeeId, year);

        if (payrolls.isEmpty()) {
            throw new RuntimeException("No payroll data found for year " + year);
        }

        double totalGross = 0;
        double totalDeductions = 0;
        double totalNet = 0;

        for (Payroll p : payrolls) {
            totalGross += p.getGrossSalary();
            totalDeductions += p.getDeductions();
            totalNet += p.getNetSalary();
        }

        AnnualSalaryDTO dto = new AnnualSalaryDTO();
        dto.setYear(year);
        dto.setTotalGrossSalary(totalGross);
        dto.setTotalDeductions(totalDeductions);
        dto.setTotalNetSalary(totalNet);

        return dto;
    }
}
