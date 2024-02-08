package com.dacm.springboot.thymeleafdemo.controller;

import com.dacm.springboot.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/showStudentsForm")
    public String showForm(Model model){

        //Create a student object
        Student theStudent = new Student();
        //Add student ibject to the model
        model.addAttribute("student",theStudent);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        //Log the input data
        System.out.println("The student: " + theStudent.getFirstName() + " " +theStudent.getLastName());

        return "student-confirmation";
    }
}
