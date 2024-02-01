package com.dacm.restfullservices.rest;

import com.dacm.restfullservices.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/students")
    public List<Student> getStudents(){

        return listStudents;
    }

}
