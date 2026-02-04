package com.sureeporn.utils;

public class DateUtils {
    public boolean isLeapYear(int year) {
        if (year < 1) {
            throw new IllegalArgumentException("Year must be positive");
        }
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }
        if (year < 1) {
            throw new IllegalArgumentException("Year must be positive");
        }
        return switch (month) {
            case 2 -> isLeapYear(year) ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };
    }

    public String getMonthName(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return months[month - 1];
    }

    public int getDayOfYear(int day, int month, int year) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Invalid day");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month");
        }
        int dayOfYear = day;
        for (int m = 1; m < month; m++) {
            dayOfYear += getDaysInMonth(m, year);
        }
        return dayOfYear;
    }
}
