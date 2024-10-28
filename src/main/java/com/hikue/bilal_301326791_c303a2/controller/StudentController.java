package com.hikue.bilal_301326791_c303a2.controller;

import com.hikue.bilal_301326791_c303a2.models.Student;
import com.hikue.bilal_301326791_c303a2.models.enums.GenderType;
import com.hikue.bilal_301326791_c303a2.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/v1/")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Tag(name = "Get Student by Id", description = "Returns a student by their id, otherwise returns an error.")
    @GetMapping("student/{id}")
    public String getStudentById(@PathVariable Long id, Model model) {
        Student student = studentService.findStudentById(id);
        if (student == null) {
            return "error/error";
        }

        model.addAttribute("student", student);
        return "student-profile";
    }

    @Tag(name = "Get Student by Email", description = "Returns a student by their email, otherwise returns an error.")
    @GetMapping("student/email/{email}")
    public String getUserByEmail(
            @PathVariable String email,
            BindingResult result,
            Model model) {
        Student student = studentService.findStudentByEmail(email);
        if (student == null || result.hasErrors()) {
            model.addAttribute("errorMessage", result.getAllErrors());
            return "error/error";
        }

        model.addAttribute("student", student);
        return "student-profile";
    }

    @Tag(name = "Get Students by Gender", description = "Returns a list of students by their gender, otherwise returns an error.")
    @GetMapping("student/gender}")
    public String getUsersByGender(@PathVariable String gender, Model model) {
        Iterable<Student> students = studentService.findAllStudentsByGender(GenderType.valueOf(gender));
        model.addAttribute("students", students);

        return "program-selection";
    }

    // TODO: Implement GetUserByStudentCredentials
    @Tag(name = "Get Student by Credentials", description = "Returns a student by various matching credentials.")
    @GetMapping("student/")
    @ResponseStatus(HttpStatus.OK)
    public String GetUserByStudentCredentials(
            @RequestParam Integer studentId,
            @RequestParam String currentProgram,
            @RequestParam Date startDate,
            @RequestParam Date endDate,
            @RequestParam String academicSkills,
            Model model,
            @ModelAttribute Student student
    ) {
        return null;
    }

    @Tag(name = "", description = "")
    @GetMapping("user/address/{city}")
    public List<Student> getUsersByCity(@PathVariable String city, Model model) {
        return null;
    }

    @Tag(name = "", description = "")
    @PostMapping("user/add/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String createUser(@PathVariable Long id, @ModelAttribute Student student) {
        return null;
    }

    @Tag(name = "", description = "")
    @PostMapping("user/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateUser(@PathVariable Long id, @ModelAttribute Student student) {
        return null;
    }

    @Tag(name = "", description = "")
    @DeleteMapping("user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser(@PathVariable Long id, Model model) {
        return null;
    }
}
