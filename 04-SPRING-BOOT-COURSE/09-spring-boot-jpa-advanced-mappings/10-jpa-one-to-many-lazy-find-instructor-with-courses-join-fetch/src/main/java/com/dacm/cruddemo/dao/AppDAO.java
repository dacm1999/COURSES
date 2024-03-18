package com.dacm.cruddemo.dao;


import com.dacm.cruddemo.entity.Course;
import com.dacm.cruddemo.entity.Instructor;
import com.dacm.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);
    void deleteInstructorById(int id);
    void deleteInstructorDetailById(int id);
    InstructorDetail findInstructorDetailById(int id);
    Instructor findInstructorById(int theId);
    List<Course> findCoursesByInstructorId(int id);



}
