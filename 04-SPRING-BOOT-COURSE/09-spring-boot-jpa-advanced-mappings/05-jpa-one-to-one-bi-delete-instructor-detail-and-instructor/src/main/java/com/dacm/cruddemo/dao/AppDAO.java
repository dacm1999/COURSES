package com.dacm.cruddemo.dao;


import com.dacm.cruddemo.entity.Instructor;
import com.dacm.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    Instructor findInstructorById(int theId);



}
