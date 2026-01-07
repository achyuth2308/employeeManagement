package com.alpha.employeeManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.employeeManagement.DTO.AnnualSalaryDTO;
import com.alpha.employeeManagement.DTO.PayrollResponseDTO;
import com.alpha.employeeManagement.Entity.Attendance;
import com.alpha.employeeManagement.Entity.BankAccount;
import com.alpha.employeeManagement.Entity.Employee;
import com.alpha.employeeManagement.Entity.Payroll;
import com.alpha.employeeManagement.Entity.PFDetails;
import com.alpha.employeeManagement.Repository.AttendanceRepository;
import com.alpha.employeeManagement.Repository.BankAccountRepository;
import com.alpha.employeeManagement.Repository.EmployeeRepository;
import com.alpha.employeeManagement.Repository.PFDetailsRepository;
import com.alpha.employeeManagement.Repository.PayrollRepository;

@Service
public class PayrollService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private PayrollRepository payrollRepository;
    
    @Autowired
    private PFDetailsRepository pfDetailsRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    // Generate payroll for a given employee
    public PayrollResponseDTO generatePayroll(int employeeId, String month, int year) {

        // Fetch employee
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // Fetch attendance
        Attendance attendance = attendanceRepository
                .findByEmployeeIdAndMonthAndYear(employeeId, month, year)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));

        // Fetch bank account
        BankAccount bankAccount = bankAccountRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Bank account not found"));

        // Fetch PF details
        PFDetails pfDetails = pfDetailsRepository.findByEmployee_Id(employeeId)
                .orElseThrow(() -> new RuntimeException("PF details not found"));

        // Salary calculations
        double monthlySalary = employee.getSalary();
        int totalWorkingDays = attendance.getTotalWorkingDays();
        int daysWorked = attendance.getWorkingdays();

        double perDaySalary = monthlySalary / totalWorkingDays;
        double earnedSalary = perDaySalary * daysWorked;

        double basic = earnedSalary * 0.50;
        double hra = earnedSalary * 0.20;
        double pf = basic * 0.12;
        double bonus = 2000;

        double grossSalary = basic + hra + bonus;
        double deductions = pf;
        double netSalary = grossSalary - deductions;

        // Save Payroll
        Payroll payroll = new Payroll();
        payroll.setMonth(month);
        payroll.setYear(year);
        payroll.setPerDaySalary(perDaySalary);
        payroll.setDaysWorked(daysWorked);
        payroll.setBasicSalary(basic);
        payroll.setHra(hra);
        payroll.setPf(pf);
        payroll.setBonus(bonus);
        payroll.setGrossSalary(grossSalary);
        payroll.setDeductions(deductions);
        payroll.setNetSalary(netSalary);
        payroll.setEmployee(employee);

        payrollRepository.save(payroll);

        // Prepare Response DTO
        PayrollResponseDTO dto = new PayrollResponseDTO();
        dto.setEmployeeId(employee.getId());
        dto.setEmployeeName(employee.getName());
        dto.setRole(employee.getRole());

        dto.setBankName(bankAccount.getBankName());
        dto.setIfscCode(bankAccount.getIfscCode());

        dto.setPfUanNumber(pfDetails.getUanNumber());      // Changed from PAN
        dto.setPfHolderName(pfDetails.getPfHolderName());   // Changed from PAN

        dto.setMonth(month);
        dto.setYear(year);
        dto.setPerDaySalary(perDaySalary);
        dto.setDaysWorked(daysWorked);

        dto.setBasicSalary(basic);
        dto.setHra(hra);
        dto.setPf(pf);
        dto.setBonus(bonus);
        dto.setGrossSalary(grossSalary);
        dto.setDeductions(deductions);
        dto.setNetSalary(netSalary);

        return dto;
    }

    // Annual Salary
    public AnnualSalaryDTO annualSalary(int employeeId, int year) {

        employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        List<Payroll> payrollList = payrollRepository.findByEmployee_IdAndYear(employeeId, year);

        if (payrollList.isEmpty()) {
            throw new RuntimeException("No payroll records found for year " + year);
        }

        // Calculate totals
        double totalGross = 0;
        double totalDeductions = 0;
        double totalNet = 0;

        for (Payroll payroll : payrollList) {
            totalGross += payroll.getGrossSalary();
            totalDeductions += payroll.getDeductions();
            totalNet += payroll.getNetSalary();
        }

        AnnualSalaryDTO dto = new AnnualSalaryDTO();
        dto.setYear(year);
        dto.setTotalGrossSalary(totalGross);
        dto.setTotalDeductions(totalDeductions);
        dto.setTotalNetSalary(totalNet);
//        dto.setMonthlyPayrolls(payrollList);

        return dto;
    }
}
