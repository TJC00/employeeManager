package com.blackamanholdings.employeemanager.controller;

import com.blackamanholdings.employeemanager.model.Employee;
import com.blackamanholdings.employeemanager.repository.EmployeeRepository;
import com.blackamanholdings.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @Author TJChidanika
 * @Date 1/6/2022
 * @TIME 19:06
 */

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }
    //saveEmployee
    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestParam(required = true) String name,
                                                 @RequestParam(required = true) String surname,
                                                 @RequestParam(required = true) String jobTitle,
                                                 @RequestParam(required = true) String imageUrl){
        Employee employee = employeeService.saveEmployee(name, surname, jobTitle, imageUrl);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    //findAllEmployee
    @GetMapping("/findAll")
    public ResponseEntity<List<Employee>> findAllEmployee(){
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    //findEmployeeById
    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable("id")String id){
        Optional<Employee> employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    //findEmployeeByEmployeeCode
    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Employee>> findEmployeeByEmployeeCode(@PathVariable("id")String id){
        Optional<Employee> employee = employeeService.findEmployeeByEmployeeCode(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    //deleteEmployeeById
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> updateEmployeeById(@PathVariable("id")String id){
       employeeService.deleteEmployeeById(id);
       return new ResponseEntity<>("Employee with "+ id + " was deleted successfully",HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") String id,
                                            @RequestParam(required = false) String jobTitle,
                                            @RequestParam(required = false) String imageUrl){
        Employee employee = employeeService.updateEmployee(id, jobTitle, imageUrl);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

}
