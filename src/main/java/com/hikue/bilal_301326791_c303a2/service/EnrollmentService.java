package com.hikue.bilal_301326791_c303a2.service;

import com.hikue.bilal_301326791_c303a2.models.Enrollment;
import com.hikue.bilal_301326791_c303a2.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public void saveEnrollment(Enrollment enrollment) {
        enrollmentRepository.save(enrollment);
    }

    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }

    public void updateEnrollment(Enrollment enrollment) {
        enrollmentRepository
                .findById(enrollment.getId())
                .ifPresentOrElse(
                        enrollmentEntity -> {
                            enrollmentEntity.setProgram(enrollment.getProgram());
                            enrollmentEntity.setStudent(enrollment.getStudent());
                            enrollmentEntity.setAmountPaid(enrollment.getAmountPaid());
                            enrollmentEntity.setApplicationStatus(enrollment.getApplicationStatus());
                        },
                        () -> {
                            throw new IllegalArgumentException(String.format("Enrollment not found with id: %s", enrollment.getId()));
                        }
                );
    }

    public Enrollment findEnrollmentById(Long id) throws IllegalArgumentException {
        return enrollmentRepository
                .findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException(String.format("Enrollment with id %d does not exist.", id)));

    }
}
