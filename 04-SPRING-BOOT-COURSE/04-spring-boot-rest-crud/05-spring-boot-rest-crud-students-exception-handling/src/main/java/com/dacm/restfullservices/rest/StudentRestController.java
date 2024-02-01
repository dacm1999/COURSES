package com.dacm.restfullservices.rest;

import com.dacm.restfullservices.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> listStudents;

    @PostConstruct
    public void loadData(){

        listStudents = new ArrayList<>();
        listStudents.add(new Student("Daniel", "Contreras"));
        listStudents.add(new Student("Luis", "Gomez"));
        listStudents.add(new Student("Nicole", "Rojas"));
        listStudents.add(new Student("Weptzel", "Morales"));

    }

    /**
     * Deine endpoint for "/studnets"
     * @return all the students
     */
    @GetMapping("/students")
    public List<Student> getStudents(){

        return listStudents;
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<Object> getStudent(@PathVariable int studentId) {
        try {
            Student student = listStudents.get(studentId);
            return ResponseEntity.ok(student);
        } catch (IndexOutOfBoundsException ibe) {
            return ResponseEntity.badRequest().body("El valor introducido no existe");
        }
    }


}
