package com.sprk.employee_management.repository;

import com.sprk.employee_management.entity.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeInfo, Long> {

    // Jakarta Persistance Query Method (JPQM)
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

    boolean existsByEmailAndEmpIdNot(String email, Long empId);
    boolean existsByPhoneAndEmpIdNot(String phone, Long empId);
}
