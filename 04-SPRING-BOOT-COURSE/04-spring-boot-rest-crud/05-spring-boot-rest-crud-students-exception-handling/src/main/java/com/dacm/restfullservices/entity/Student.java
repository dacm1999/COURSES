package com.dacm.restfullservices.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {

    private String firstName;
    private String lastname;

    public Student() {
    }

    public Student(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
