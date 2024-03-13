package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.implementedService.EmployeeServiceImpl;
import com.luv2code.springboot.cruddemo.service.interfaceService.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @GetMapping("/list")
    public String listEmployee(Model themodel){
        //Get the employees from db
        List<Employee> theEmployees = employeeService.findAll();

        themodel.addAttribute("employees",theEmployees);
        //Add to the spring model


        return "list-employees";
    }

}
