package com.hikue.bilal_301326791_c303a2.service;

import com.hikue.bilal_301326791_c303a2.models.Address;
import com.hikue.bilal_301326791_c303a2.models.Student;
import com.hikue.bilal_301326791_c303a2.models.StudentCredentials;
import com.hikue.bilal_301326791_c303a2.models.enums.GenderType;
import com.hikue.bilal_301326791_c303a2.repository.StudentRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveStudent(@NonNull Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(@NonNull Long id) {
        studentRepository.deleteById(id);
    }

    public void updateStudent(@NonNull Student student) {
        studentRepository
                .findById(student.getId())
                .ifPresentOrElse(
                        studentEntity -> {
                            studentEntity.setLegalFirstName(student.getLegalFirstName());
                            studentEntity.setLegalLastName(student.getLegalLastName());
                            studentEntity.setBirthDate(student.getBirthDate());
                            studentEntity.setGender(student.getGender());
                            studentEntity.setEmail(student.getEmail());
                            studentEntity.setPhoneNumber(student.getPhoneNumber());
                            studentEntity.setAddress(student.getAddress());
                            studentEntity.setStudentCredentials(student.getStudentCredentials());
                            studentEntity.setCreatedAt(student.getCreatedAt());
                            studentEntity.setUpdatedAt(student.getUpdatedAt());
                        },
                        () -> {
                            throw new IllegalArgumentException("Student with id " + student.getId() + " does not exist.");
                        });
    }

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student findStudentById(@NonNull Long id) throws IllegalArgumentException {
        Student student = studentRepository.findStudentById(id);
        if (student == null) {
            throw new IllegalArgumentException(String.format("Student with id %d does not exist.", id));
        }

        return student;
    }

    public Student findStudentByEmail(@NonNull String email) throws IllegalArgumentException {
        Student student = studentRepository.findStudentByEmail(email);
        if (student == null) {
            throw new IllegalArgumentException(String.format("Student with email: %s does not exist.", email));
        }

        return student;
    }

    // TODO: Check if this method works properly.
    public Iterable<Student> findAllStudentsByGender(@NonNull GenderType genderType) {
        return studentRepository.findAllByGender(genderType);
    }

    // TODO: Check if this method works properly.
    public Student findFirstStudentByGender(@NonNull GenderType genderType) {
        return studentRepository.findAllByGender(genderType).iterator().next();
    }

    // TODO: Check if this method works properly.
    public Student findStudentByStudentCredentials(@NonNull StudentCredentials studentCredentials) {
        Student student = studentRepository.findStudentByStudentCredentials(studentCredentials);

        if (student == null) {
            throw new IllegalArgumentException(String.format("Student with student credentials: %s does not exist.", studentCredentials));
        }

        return student;
    }

    // TODO: Check if this method works properly.
    public Student findStudentByAddressContainingIgnoreCase(@NonNull Address address) {
        Student student = studentRepository
                .findStudentByAddressContainingIgnoreCase(address)
                .stream()
                .findFirst()
                .orElse(null);

        if (student == null) {
            throw new IllegalArgumentException(String.format("Student with address: %s does not exist.", address));
        }

        return student;
    }

    public boolean isStudentExist(@NonNull Student student) {
        return studentRepository.findStudentById(student.getId()) != null;
    }

    public boolean studentLogin(
            @NonNull String email,
            @NonNull String password) {
        Student student = studentRepository
                .findStudentByEmail(email);

        return student != null && student.getPassword().equals(password);
    }
}
