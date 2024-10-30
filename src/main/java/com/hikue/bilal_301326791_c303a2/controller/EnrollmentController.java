package com.hikue.bilal_301326791_c303a2.controller;


import com.hikue.bilal_301326791_c303a2.models.Program;
import com.hikue.bilal_301326791_c303a2.models.Student;
import com.hikue.bilal_301326791_c303a2.service.EnrollmentService;
import com.hikue.bilal_301326791_c303a2.service.ProgramService;
import com.hikue.bilal_301326791_c303a2.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/enrollment")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;
    private final StudentService studentService;
    private final ProgramService programService;

    @Autowired
    public EnrollmentController(
            EnrollmentService enrollmentService,
            StudentService studentService,
            ProgramService programService) {
        this.enrollmentService = enrollmentService;
        this.studentService = studentService;
        this.programService = programService;
    }

    @Tag(name = "Get Enrollment Form for a Program", description = "Returns the enrollment form for a program.")
    @GetMapping("/form")
    @ResponseStatus(HttpStatus.OK)
    public String getEnrollmentForm(@RequestParam Long programId, @RequestParam Long studentId, Model model) {
        Program program = programService.findProgramById(programId);
        Student student = studentService.findStudentById(studentId);

        if (program == null || student == null) {
            model.addAttribute("errorMessage", String.format("Program with the id: %s or Student with the id: %s could not be found.", programId, studentId));
            return "redirect:/error";
        }

        model.addAttribute("program", program);
        model.addAttribute("student", student);
        return "enrollment-checkout";
    }


    @Tag(name = "Post Enrollment Form for a Program", description = "Returns the confirmation of the enrollment.")
    @PostMapping("/form")
    @ResponseStatus(HttpStatus.OK)
    public String postEnrollmentForm(@RequestParam Long programId, @RequestParam Long studentId, Model model) {
        Program program = programService.findProgramById(programId);
        Student student = studentService.findStudentById(studentId);

        if (program == null || student == null) {
            model.addAttribute("errorMessage", String.format("Program with the id: %s or Student with the id: %s could not be found.", programId, studentId));
            return "redirect:/error";
        }

        model.addAttribute("program", program);
        model.addAttribute("student", student);
        return "enrollment-confirmation";
    }
}
