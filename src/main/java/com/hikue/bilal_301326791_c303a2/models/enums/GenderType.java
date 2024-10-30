package com.hikue.bilal_301326791_c303a2.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenderType {
    MALE("male"),
    FEMALE("female"),
    PREFER_NOT_TO_SAY("pnts"),
    OTHER("other");

    private final String gender;
}
