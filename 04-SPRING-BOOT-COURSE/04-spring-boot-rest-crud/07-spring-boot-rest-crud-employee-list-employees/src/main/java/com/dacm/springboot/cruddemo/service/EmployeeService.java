package com.dacm.springboot.cruddemo.service;

import com.dacm.springboot.cruddemo.dao.EmployeeDAO;
import com.dacm.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

}
