package com.hikue.bilal_301326791_c303a2.models;

import com.hikue.bilal_301326791_c303a2.models.enums.ApplicationStatusType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "ead_enrollments")
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Application ID is required, and must be provided.")
    @Column(name = "application_id")
    private Long applicationId;

    @NotBlank(message = "Student ID is required, and must be provided.")
    @Column(name = "student_id")
    private Long studentId;

    @NotBlank(message = "Program code is required, and must be provided.")
    @Column(name = "program_code")
    private String programCode;

    @NotBlank(message = "Program start date is required, and must be provided.")
    @Column(name = "program_start_date")
    private Date programStartDate;

    @NotBlank(message = "Amount paid is required, and must be provided.")
    @Min(value = 0, message = "Amount paid must be greater than or equal to zero.")
    @Column(name = "amount_paid")
    private double amountPaid;

    @NotBlank(message = "Application status is required, and must be provided.")
    @Enumerated(EnumType.STRING)
    @Column(name = "application_status")
    private ApplicationStatusType applicationStatus;

    //region Timestamps Information
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;
    //endregion

    @PrePersist
    public void onCreate() {
        createdAt = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = new Date();
    }
}
