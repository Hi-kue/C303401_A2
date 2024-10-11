package com.hikue.bilal_301326791_c303a2.repository;

import com.hikue.bilal_301326791_c303a2.models.Student;
import com.hikue.bilal_301326791_c303a2.models.enums.GenderType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long>{
    Optional<Student> searchStudentById(Long id);
    Optional<Student> searchStudentByEmail(String email);
    Optional<List<Student>> searchStudentsByCurrentProgram(String currentProgram);
    Optional<Student> searchStudentByStudentId(Integer studentId);
    Optional<List<Student>> searchStudentsByFirstName(String firstName);
    Optional<List<Student>> searchAllByGender(GenderType genderType);
}
