package com.dacm.cruddemo.dao;


import com.dacm.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    void deleteInstructorById(int id);
    Instructor findInstructorById(int theId);



}
