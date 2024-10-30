package com.hikue.bilal_301326791_c303a2.service;

import com.hikue.bilal_301326791_c303a2.models.Program;
import com.hikue.bilal_301326791_c303a2.models.enums.ProgramStatusType;
import com.hikue.bilal_301326791_c303a2.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramService {
    private final ProgramRepository programRepository;

    @Autowired
    public ProgramService(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    public void saveProgram(Program program) {
        return;
    }

    public void deleteProgram(Long id) {
        return;
    }

    public void updateProgram(Program program) {
        return;
    }

    public Program findProgramById(Long id) {
        return null;
    }

    public Iterable<Program> findAllPrograms() {
        return null;
    }

    public Program findProgramByProgramStatus(ProgramStatusType programStatus) {
        return null;
    }
}
