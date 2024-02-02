package com.dacm.restfullservices.rest;

import com.dacm.restfullservices.entity.Student;
import com.dacm.restfullservices.entity.StudentErrorResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> listStudents;

    @PostConstruct
    public void loadData() {

        listStudents = new ArrayList<>();
        listStudents.add(new Student("Daniel", "Contreras"));
        listStudents.add(new Student("Luis", "Gomez"));
        listStudents.add(new Student("Nicole", "Rojas"));
        listStudents.add(new Student("Weptzel", "Morales"));

    }

    /**
     * Deine endpoint for "/studnets"
     *
     * @return all the students
     */
    @GetMapping("/students")
    public List<Student> getStudents() {

        return listStudents;
    }

    /**
     * define endpoint or "/students/{studentId}" - return student at index
     * @param studentId id of student
     * @return info about student
     */
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if ((studentId >= listStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return listStudents.get(studentId);
    }

}
