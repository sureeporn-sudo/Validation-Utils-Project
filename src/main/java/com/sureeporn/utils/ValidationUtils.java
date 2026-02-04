package com.sureeporn.utils;

public class ValidationUtils {
    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        // At least 8 characters, one uppercase, one lowercase, one digit
        if (password.length() < 8) return false;
        boolean hasUpper = false, hasLower = false, hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isLowerCase(c)) hasLower = true;
            if (Character.isDigit(c)) hasDigit = true;
        }
        return hasUpper && hasLower && hasDigit;
    }

    public boolean isValidPhoneNumber(String phone) {
        if (phone == null) {
            return false;
        }
        // Accepts formats: 123-456-7890, (123) 456-7890, 1234567890
        return phone.matches("^(\\d{3}-\\d{3}-\\d{4}|\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{10})$");
    }

    public boolean isValidZipCode(String zipCode) {
        if (zipCode == null) {
            return false;
        }
        // Accepts 5 digits or 5+4 format
        return zipCode.matches("^\\d{5}(-\\d{4})?$");
    }
}
