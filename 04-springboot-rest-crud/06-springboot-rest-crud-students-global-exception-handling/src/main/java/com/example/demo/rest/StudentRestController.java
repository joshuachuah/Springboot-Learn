package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> students;


    // define @PostConstruct to load the student data only once

    @PostConstruct
    public void loadData() {

        students = new ArrayList<>();

        students.add(new Student("Max", "Verstappen"));
        students.add(new Student("Lando", "Norris"));
        students.add(new Student("Pierre", "Gasly"));
    }

    // define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // check studentId against list size
        if ( (studentId >= students.size()) || (studentId < 0) ) {
            throw new StudentNotFoundException("Student with id " + studentId + " not found");
        }

        return students.get(studentId);
    }

}
