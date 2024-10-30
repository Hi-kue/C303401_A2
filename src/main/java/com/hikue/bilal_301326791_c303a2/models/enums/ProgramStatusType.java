package com.hikue.bilal_301326791_c303a2.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProgramStatusType {
    ACTIVE("active"),
    UPCOMING("upcoming"),
    COMPLETED("completed");

    private final String status;
}
