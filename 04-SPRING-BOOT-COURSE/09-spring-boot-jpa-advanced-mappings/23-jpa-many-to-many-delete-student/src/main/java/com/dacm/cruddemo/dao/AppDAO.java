package com.dacm.cruddemo.dao;


import com.dacm.cruddemo.entity.Course;
import com.dacm.cruddemo.entity.Instructor;
import com.dacm.cruddemo.entity.InstructorDetail;
import com.dacm.cruddemo.entity.Student;

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
    void update(Student tempStudent);
    void deleteStudentById(int id);
    Instructor findInstructorById(int theId);
    Instructor findInstructorByJoinFetch(int id);
    Course findCourseById(int id);
    Course findCourseAndReviewById(int id);
    Course findCourseAndStudentsByCourseId(int id);
    Student findStudentAndCoursesByStudentId(int id);
    List<Course> findCoursesByInstructorId(int id);




}
