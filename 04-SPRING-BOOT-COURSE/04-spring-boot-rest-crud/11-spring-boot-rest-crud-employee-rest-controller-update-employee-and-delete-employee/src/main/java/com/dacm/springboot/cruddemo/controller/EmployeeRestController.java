package com.dacm.springboot.cruddemo.controller;

import com.dacm.springboot.cruddemo.entity.Employee;
import com.dacm.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Employee getEmployee(@PathVariable int userID) {

        Employee theEmployee = employeeService.findByID(userID);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found " + userID);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        //This is to force a save of a new item ... instedad of update
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        Employee dbEmoployee = employeeService.save(theEmployee);
        return dbEmoployee;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee tempEmployee = employeeService.findByID(employeeId);

        // throw exception if null

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);


        return "DELETED USER: " +  "\\ "+tempEmployee.toString();
        //        return "Deleted employee id - " + employeeId;
    }
}
