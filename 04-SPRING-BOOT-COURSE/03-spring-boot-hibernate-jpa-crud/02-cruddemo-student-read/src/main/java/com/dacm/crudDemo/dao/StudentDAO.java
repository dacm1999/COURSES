package com.dacm.crudDemo.dao;

import com.dacm.crudDemo.entity.Student;
import org.springframework.stereotype.Repository;

public interface StudentDAO {

    void save (Student theStudent);
    Student findById(Integer id);

}
