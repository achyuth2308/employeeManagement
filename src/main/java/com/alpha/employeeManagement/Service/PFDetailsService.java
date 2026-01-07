package com.alpha.employeeManagement.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.employeeManagement.DTO.PFDetailsDTO;
import com.alpha.employeeManagement.Entity.Employee;
import com.alpha.employeeManagement.Entity.PFDetails;
import com.alpha.employeeManagement.Repository.EmployeeRepository;
import com.alpha.employeeManagement.Repository.PFDetailsRepository;

@Service
public class PFDetailsService {

    @Autowired
    private PFDetailsRepository pfDetailsRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Save PF Details using DTO
    public PFDetails savePFDetails(PFDetailsDTO pfDetailsDTO) throws Exception {
        // Check if employee exists
        Optional<Employee> employeeOpt = employeeRepository.findById(pfDetailsDTO.getEmployeeId());
        if (!employeeOpt.isPresent()) {
            throw new Exception("Employee not found with ID: " + pfDetailsDTO.getEmployeeId());
        }

        Employee employee = employeeOpt.get();

        // Check if PF is already assigned to employee
        if (pfDetailsRepository.findByEmployee_Id(employee.getId()).isPresent()) {
            throw new Exception("PF details already exist for this employee.");
        }

        // Map DTO to Entity
        PFDetails pfDetails = new PFDetails();
        pfDetails.setUanNumber(pfDetailsDTO.getUanNumber());
        pfDetails.setPfHolderName(employee.getName()); // Assuming PF holder name = employee name
        pfDetails.setEmployee(employee);

        return pfDetailsRepository.save(pfDetails);
    }
}
