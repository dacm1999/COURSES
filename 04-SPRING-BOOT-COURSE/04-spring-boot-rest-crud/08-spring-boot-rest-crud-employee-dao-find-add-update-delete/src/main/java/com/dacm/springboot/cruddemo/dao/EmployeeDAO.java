package com.dacm.springboot.cruddemo.dao;

import com.dacm.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

}
