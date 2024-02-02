package com.dacm.springboot.cruddemo.dao;

import com.dacm.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmployeeDAOJpaImp implements EmployeeDAO {

    private EntityManager entityManager;
    private List<Employee> employeeList;

    @Autowired
    public EmployeeDAOJpaImp(EntityManager entityManager) {
        this.entityManager = entityManager;
        employeeList = new ArrayList<>();
    }

    /**
     * Show all employers
     * @return
     */
    @Override
    public List<Employee> findAll() {
        //Create a queary
        TypedQuery<Employee> theQueary = entityManager.createQuery("from Employee ", Employee.class);
        //Execute query and get result list
        employeeList = theQueary.getResultList();

        return employeeList;
    }

    /**
     * Find user by ID
     * @param userID user id
     * @return ifnromation about user
     */
    @Override
    public Employee findByID(int userID) {
        Employee theEmployee = entityManager.find(Employee.class, userID);
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        //save empleoyee
        Employee dbEmployee = entityManager.merge(employee);

        return dbEmployee;
    }

    @Override
    public void deleteById(int userID) {

        //fin employee by id
        Employee theEmployee = entityManager.find(Employee.class, userID);
        entityManager.remove(theEmployee);
    }
}
