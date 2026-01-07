package com.alpha.employeeManagement;

import java.security.SecureRandom;

public class AccountNumberGenerator {

    private static final SecureRandom random = new SecureRandom();

    public static String generateAccountNumber() {
        int length = random.nextInt(5) + 12;

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
