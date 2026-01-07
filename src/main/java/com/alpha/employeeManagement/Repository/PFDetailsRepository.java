package com.alpha.employeeManagement.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.alpha.employeeManagement.Entity.PFDetails;

public interface PFDetailsRepository extends JpaRepository<PFDetails, Integer> {

    Optional<PFDetails> findByEmployee_Id(int employeeId);
}
