package com.alpha.employeeManagement.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.employeeManagement.Entity.Payroll;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {

    Optional<Payroll> findById(Long payrollId);

    Optional<Payroll> findByEmployee_IdAndMonthAndYear(int employeeId, String month, int year);

    List<Payroll> findByEmployee_IdAndYear(int employeeId, int year);

    List<Payroll> findByEmployee_Id(int employeeId);
}
