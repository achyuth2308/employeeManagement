package com.alpha.employeeManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alpha.employeeManagement.Entity.Attendance;
import com.alpha.employeeManagement.Service.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/add")
    public ResponseEntity<Attendance> addAttendance(
            @RequestParam int id,
            @RequestBody Attendance attendance) {

        return ResponseEntity.ok(
                attendanceService.saveAttendance(id, attendance)
        );
    }
}

