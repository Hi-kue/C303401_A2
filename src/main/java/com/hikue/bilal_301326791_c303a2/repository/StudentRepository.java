package com.hikue.bilal_301326791_c303a2.repository;

import com.hikue.bilal_301326791_c303a2.models.Student;
import com.hikue.bilal_301326791_c303a2.models.StudentCredentials;
import com.hikue.bilal_301326791_c303a2.models.enums.GenderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    Student findStudentById(Long id);
    Student findStudentByEmail(String email);
    List<Student> findAllByGender(GenderType genderType);
    Student findStudentByStudentCredentials(StudentCredentials studentCredentials);
}
