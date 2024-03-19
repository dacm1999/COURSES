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
    void save(Course course);
    void deleteInstructorById2(int id);
    void updateInstructor(Instructor instructor);
    void deleteCoursebyId(int id);
    void updateCourse(Course course);
    Instructor findInstructorById(int theId);
    Instructor findInstructorByJoinFetch(int id);
    Course findCourseById(int id);
    Course findCourseAndReviewById(int id);
    List<Course> findCoursesByInstructorId(int id);




}