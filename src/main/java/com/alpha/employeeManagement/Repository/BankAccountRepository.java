package com.alpha.employeeManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.employeeManagement.Entity.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

    Optional<BankAccount> findByEmployee_Id(int employeeId);
}

