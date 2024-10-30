package com.hikue.bilal_301326791_c303a2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1/")
public class ProgramController {
    @GetMapping("program/form")
    public String getProgramFrom(Model model) {
        return null;
    }

    @PostMapping("program/add")
    public String addProgram(
            @RequestParam String programCode,
            @RequestParam String programName,
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam String programFee,
            @RequestParam String professorName) {
        return null;
    }

    @PostMapping("program/update")
    public String updateProgram(
            @RequestParam String programCode,
            @RequestParam String programName,
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam String programFee,
            @RequestParam String professorName) {
        return null;
    }
}
