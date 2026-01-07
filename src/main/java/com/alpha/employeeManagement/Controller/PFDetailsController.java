package com.alpha.employeeManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alpha.employeeManagement.DTO.PFDetailsDTO;
import com.alpha.employeeManagement.Entity.PFDetails;
import com.alpha.employeeManagement.Service.PFDetailsService;

@RestController
@RequestMapping("/api/pf")
public class PFDetailsController {

    @Autowired
    private PFDetailsService pfDetailsService;

    // Save PF Details
    @PostMapping("/save")
    public ResponseEntity<?> savePFDetails(@RequestParam int id,@RequestBody PFDetailsDTO pfDetailsDTO) {
        try {
            PFDetails savedPF = pfDetailsService.savePFDetails(pfDetailsDTO);
            return ResponseEntity.ok(savedPF);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
