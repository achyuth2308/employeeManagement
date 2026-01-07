package com.alpha.employeeManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.employeeManagement.Entity.Attendance;
import com.alpha.employeeManagement.Entity.Employee;
import com.alpha.employeeManagement.Repository.AttendanceRepository;
import com.alpha.employeeManagement.Repository.EmployeeRepository;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Attendance saveAttendance(int id, Attendance attendance) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

//prevent duplicate attendance for same month/year
        attendanceRepository.findByEmployeeIdAndMonthAndYear(id,attendance.getMonth(),attendance.getYear())
            .ifPresent(a -> {
                throw new RuntimeException(
                        "Attendance already exists for this month and year"
                );
            });

        attendance.setEmployee(employee);

        return attendanceRepository.save(attendance);
    }
}
