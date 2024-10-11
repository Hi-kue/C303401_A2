package com.hikue.bilal_301326791_c303a2.models;

import com.hikue.bilal_301326791_c303a2.models.enums.GenderType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "ead_students")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // NOTE: This is not the Student's ID, rather a primary key.

    @NotBlank(message = "First name is required, and must be provided.")
    @Column(name = "legal_fname")
    private String legalFirstName;

    @NotBlank(message = "Legal last name is required, and must be provided.")
    @Column(name = "legal_lname")
    private String legalLastName;

    @NotBlank(message = "Birth date is required, and must be provided.")
    @Column(name = "birth_date")
    private Date birthDate;

    @NotBlank(message = "Gender type is required, and must be provided.")
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GenderType gender;

    @NotBlank(message = "Email is required, and must be provided.")
    @Pattern(
            regexp = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-zA-Z]{2,})$",
            message = "Email provided is invalid.")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Phone number is required, and must be provided.")
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number provided is invalid.")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotBlank(message = "Address is required, and must be provided.")
    @Column(name = "address")
    @Embedded
    private Address address;

    @NotBlank(message = "Student credentials is required, and must be provided.")
    @Column(name = "student_credentials")
    private StudentCredentials studentCredentials;

    //region Timestamps Information
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;
    //endregion
}

