package com.hikue.bilal_301326791_c303a2.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class BoundedComponents {
    private static final String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String getStatusClass(String status) {
        final var classes = new String[]{
                "bg-green-100 text-green-800",
                "bg-blue-100 text-blue-800",
                "bg-gray-100 text-gray-800"
        };
        return classes[status.equals("active") ? 0 : status.equals("upcoming") ? 1 : 2];
    }

    public static String generateProgramCode(int length) {
        StringBuilder programCode = new StringBuilder("PROGRAM-");
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            programCode.append(characters.charAt(random.nextInt(characters.length())));
        }

        return programCode.toString();
    }
}
