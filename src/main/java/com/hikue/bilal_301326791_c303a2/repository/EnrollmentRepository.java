package com.hikue.bilal_301326791_c303a2.repository;

import com.hikue.bilal_301326791_c303a2.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> { }
