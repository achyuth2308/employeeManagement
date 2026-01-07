package com.alpha.employeeManagement.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pf_details")
public class PFDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String uanNumber;

    @Column(nullable = false)
    private String pfHolderName;

    @OneToOne
    @JoinColumn(name = "employee_id", unique = true)
    private Employee employee;

    public PFDetails() {
        super();
    }

    public PFDetails(String uanNumber, String pfHolderName, Employee employee) {
        this.uanNumber = uanNumber;
        this.pfHolderName = pfHolderName;
        this.employee = employee;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUanNumber() { return uanNumber; }
    public void setUanNumber(String uanNumber) { this.uanNumber = uanNumber; }

    public String getPfHolderName() { return pfHolderName; }
    public void setPfHolderName(String pfHolderName) { this.pfHolderName = pfHolderName; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    @Override
    public String toString() {
        return "PFDetails [id=" + id + ", uanNumber=" + uanNumber + ", pfHolderName=" + pfHolderName + ", employee=" + employee + "]";
    }
}
