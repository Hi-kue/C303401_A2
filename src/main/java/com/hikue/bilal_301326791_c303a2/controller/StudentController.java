package com.hikue.bilal_301326791_c303a2.controller;

import com.hikue.bilal_301326791_c303a2.repository.StudentRepository;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/")
public class StudentController {
    @PersistenceContext
    private StudentRepository studentRepository;

    @GetMapping("/home")
    public String index() {
        return "index";
    }
}
