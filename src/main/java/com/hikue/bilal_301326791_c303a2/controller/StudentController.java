package com.hikue.bilal_301326791_c303a2.controller;

import com.hikue.bilal_301326791_c303a2.models.Student;
import com.hikue.bilal_301326791_c303a2.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Get /api/v1/student/ endpoint
     * This endpoint is used to display the index page of the application,
     * which is a form that allows the user to register as a new student, or
     * to login as an existing student.
     *
     * @param model  The model that will be used within the index page.
     * @return The index page (which contains a form for registration or login).
     */
    @Tag(name = "Get Index Page", description = "Returns the index page (form) for the application.")
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String showIndexPage(Model model) {
        model.addAttribute("student", new Student());
        return "index";
    }

    /**
     *
     * Get /api/v1/student/profile?id={id} endpoint
     *
     * This endpoint is used to display the student profile page of the
     * application, which is a page that displays the student's personal
     * information, academic information, and system information.
     *
     * @param id The id of the student to be displayed to the profile page.
     * @param model The model that will be used within the profile page.
     * @return The student profile page with the student's information.
     */
    @Tag(name = "Show Student Profile Page", description = "Returns the student profile page for the application.")
    @GetMapping("/profile")
    @ResponseStatus(HttpStatus.OK)
    public String showStudentProfilePage(@RequestParam long id, Model model) {
        Student student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        return "student-profile";
    }

    /**
     * Get /api/v1/student/profile?id={id} endpoint
     * This endpoint is used to display the student profile page of the
     * application, which is a page that displays the student's personal
     * information, academic information, and system information.
     *
     * @param id The id of the student to be displayed to the profile page.
     * @param model The model that will be used within the profile page.
     * @return The student profile page with the student's information.
     */
    @Tag(name = "Get Student by Id", description = "Returns a student by their id, otherwise returns an error.")
    @GetMapping("/profile")
    @ResponseStatus(HttpStatus.OK)
    public String getStudentById(@RequestParam Long id, BindingResult result, Model model) {
        Student student = studentService.findStudentById(id);

        if (student == null || result.hasErrors()) {
            model.addAttribute("errorMessage", String.format("Student with the id: %s could not be found.", id));
            return "error/error";
        }

        model.addAttribute("student", student);
        return "student-profile";
    }

    /**
     * Get /api/v1/student/email?email={email} endpoint
     * This endpoint is used to display the student profile page of the
     * application, which is a page that displays the student's personal
     * information, academic information, and system information.
     *
     * @param email The email of the student to be displayed to the profile page.
     * @param result The result of the binding of the email.
     * @param model The model that will be used within the profile page.
     * @return The student profile page with the student's information.
     */
    @Tag(name = "Get Student by Email", description = "Returns a student by their email, otherwise returns an error.")
    @GetMapping("/profile")
    @ResponseStatus(HttpStatus.OK)
    public String findStudentByEmail(@RequestParam String email, BindingResult result, Model model) {
        Student student = studentService.findStudentByEmail(email);

        if (student == null || result.hasErrors()) {
            model.addAttribute("errorMessage", result.getAllErrors());
            return "error/error";
        }

        model.addAttribute("student", student);
        return "student-profile";
    }

    @Tag(name = "Login Student", description = "")
}
