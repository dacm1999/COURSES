package com.dacm.crudDemo.dao;

import com.dacm.crudDemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save (Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();

    List<Student> findByFirstName(String firsName);

    void update(Student student);

}
