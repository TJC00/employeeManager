package com.blackamanholdings.employeemanager.repository;

import com.blackamanholdings.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Author TJChidanika
 * @Date 1/6/2022
 * @TIME 18:46
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Optional<Employee> findEmployeeByEmployeeCode(String employeeCode);
    List<Employee> findEmployeeByJobTitleAndAnd(String jobTitle, String employeeCode );
}
