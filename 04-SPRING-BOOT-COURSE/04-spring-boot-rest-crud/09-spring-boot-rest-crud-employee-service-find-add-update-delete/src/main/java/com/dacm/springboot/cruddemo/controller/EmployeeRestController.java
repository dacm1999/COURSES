package com.dacm.springboot.cruddemo.controller;

import com.dacm.springboot.cruddemo.entity.Employee;
import com.dacm.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // Quick and dirert: inject empleyee DAO

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{userID}")
    public Employee getEmployee(@PathVariable int userID){

        Employee theEmployee = employeeService.findByID(userID);

        if(theEmployee == null){
            throw  new RuntimeException("Employee id not found " + userID);
        }

        return  theEmployee;
    }
}
