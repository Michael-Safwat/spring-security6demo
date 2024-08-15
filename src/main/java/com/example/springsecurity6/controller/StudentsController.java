package com.example.springsecurity6.controller;

import com.example.springsecurity6.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentsController {

    private List<Student> studentsList = new ArrayList<>(List.of(
            new Student(1,"Michael",100),
            new Student(2,"SherLoyd",100)
    ));

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return studentsList;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student)
    {
        studentsList.add(student);
        return student;
    }
}
