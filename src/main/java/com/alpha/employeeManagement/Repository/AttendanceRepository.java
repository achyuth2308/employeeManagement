package com.alpha.employeeManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.employeeManagement.Entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {


	Optional<Attendance> findByEmployeeIdAndMonthAndYear(int employeeId, String month, int year);
}

