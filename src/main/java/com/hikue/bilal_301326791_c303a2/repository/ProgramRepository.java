package com.hikue.bilal_301326791_c303a2.repository;

import com.hikue.bilal_301326791_c303a2.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {

}
