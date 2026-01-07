package com.alpha.employeeManagement.DTO;

public class PFDetailsDTO {

    private String uanNumber;
    private int employeeId; // Just send Employee ID instead of full Employee object

    public PFDetailsDTO() {
        super();
    }

    public PFDetailsDTO(String uanNumber, int employeeId) {
        this.uanNumber = uanNumber;
        this.employeeId = employeeId;
    }

    // Getters and Setters
    public String getUanNumber() { return uanNumber; }
    public void setUanNumber(String uanNumber) { this.uanNumber = uanNumber; }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    @Override
    public String toString() {
        return "PFDetailsDTO [uanNumber=" + uanNumber + ", employeeId=" + employeeId + "]";
    }
}
