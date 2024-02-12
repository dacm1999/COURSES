package com.dacm.springboot.thymeleafdemo.controller;

import com.dacm.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;
import java.util.List;

@Controller
public class StudentController {

    @Value("${operatingSystems}")
    private List<String> operatingSystems;

    @Value("${languages}")
    private List<String> languages;

    @Value("${countries}")
    private List<String> countries;

    @GetMapping("/showStudentsForm")
    public String showForm(Model model){

        //Create a student object
        Student theStudent = new Student();
        //Add student ibject to the model
        model.addAttribute("student",theStudent);
        //Add the list of countries to the model
        model.addAttribute("countries",countries);
        //Add the list of languages to the model
        model.addAttribute("languages",languages);
        //Add the list of operating systems to the model
        model.addAttribute("operatingSystems", operatingSystems);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        //Log the input data
        System.out.println("The student: " + theStudent.getFirstName() + " " +theStudent.getLastName());

        return "student-confirmation";
    }
}
