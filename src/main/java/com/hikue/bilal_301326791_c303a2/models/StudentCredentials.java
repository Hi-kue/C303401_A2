package com.hikue.bilal_301326791_c303a2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Embeddable
public class StudentCredentials implements Serializable {
    @NotBlank(message = "Student Id is required, and must be provided.")
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Student Id provided is invalid.")
    Integer studentId;

    @NotBlank(message = "Current program is required, and must be provided.")
    String currentProgram;

    @NotBlank(message = "Start date is required, and must be provided.")
    @Pattern(
            regexp = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$",
            message = "Start date provided is invalid.")
    Date startDate;

    @Pattern(
            regexp = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$",
            message = "End date provided is invalid.")
    Date endDate;

    @ElementCollection
    @CollectionTable(
            name = "ead_student_acd_skills",
            joinColumns = @JoinColumn(name = "student_id")
    )
    ArrayList<String> academicSkills; // NOTE: Would have been named "technicalSkills" but it didn't sound right.
}