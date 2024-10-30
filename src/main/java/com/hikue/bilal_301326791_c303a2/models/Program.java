package com.hikue.bilal_301326791_c303a2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "ead_programs")
@AllArgsConstructor
@NoArgsConstructor
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Program code is required, and must be provided.")
    @Column(name = "program_code",unique = true)
    private String programCode;

    @NotBlank(message = "Program name is required, and must be provided.")
    @Column(name = "program_name", unique = true)
    private String programName;

    @NotBlank(message = "Program start date is required, and must be provided.")
    @Column(name = "program_start_date")
    private Date programStartDate;

    @NotBlank(message = "Program end date is required, and must be provided.")
    @Column(name = "program_end_date")
    private Date programEndDate;

    @NotBlank(message = "Program fee is required, and must be provided.")
    @Column(name = "program_fee")
    private double programFee;

    @NotBlank(message = "Program professor is required, and must be provided.")
    @Pattern(
            regexp = "^[a-zA-Z\\s]{2,}$",
            message = "Program professor provided is invalid."
    )
    @Column(name = "program_professor")
    private String programProfessor;

    @NotBlank(message = "Program status is required, and must be provided.")
    @Column(name = "program_status")
    private String programStatus;

    //region Timestamps Information
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;
    //endregion
}

