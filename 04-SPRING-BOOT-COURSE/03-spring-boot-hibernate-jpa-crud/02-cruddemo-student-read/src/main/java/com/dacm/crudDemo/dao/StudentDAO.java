package com.dacm.crudDemo.dao;

import com.dacm.crudDemo.entity.Student;
import org.springframework.stereotype.Repository;

public interface StudentDAO {

    public void save (Student theStudent);

}
