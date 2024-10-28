package com.hikue.bilal_301326791_c303a2.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionsHandler {
    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "error/error";
    }

    @ExceptionHandler(value = RuntimeException.class)
    public String handleException(RuntimeException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "error/error";
    }

    // NOTE: If there is a reason to add any other exception, follow the above pattern.
}
