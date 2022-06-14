package com.blackamanholdings.employeemanager.service;

import com.blackamanholdings.employeemanager.model.Employee;
import com.blackamanholdings.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * @Author TJChidanika
 * @Date 1/6/2022
 * @TIME 18:47
 */
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    //saveEmployee
    public Employee saveEmployee(String name, String surname,String jobTitle,String  imageUrl){
        Employee employee = new Employee();

        employee.setEmployeeCode(UUID.randomUUID().toString());
        employee.setId(UUID.randomUUID().toString());
        employee.setName(name);
        employee.setSurname(surname);
        employee.setJobTitle(jobTitle);
        employee.setImageUrl(imageUrl);

        return employeeRepository.save(employee);
    }
    //findAllEmployees
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }
    //findEmployeeById
    public Optional<Employee> findEmployeeById(String id){
        return employeeRepository.findById(id);
    }
    //findEmployeeByEmployeeCode
    public Optional<Employee> findEmployeeByEmployeeCode(String employeeCode){
        return employeeRepository.findEmployeeByEmployeeCode(employeeCode);
    }
    //deleteEmployeeById
    public void deleteEmployeeById(String id){
        employeeRepository.deleteById(id);
    }
    //updateEmployee
    @Transactional
    public Employee updateEmployee(String id, String jobTitle, String imageUrl) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException(
                        "Employee with id "+id+" not found"
                ));
        if(jobTitle != null && jobTitle.length()>0 && !Objects.equals(employee.getJobTitle(), jobTitle)){
            employee.setJobTitle(jobTitle);
        }
        if(imageUrl != null && imageUrl.length()>0 && !Objects.equals(employee.getImageUrl(), imageUrl)){
            employee.setImageUrl(imageUrl);
        }
        return employee;
    }
}
