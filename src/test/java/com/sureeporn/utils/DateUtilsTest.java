package com.sureeporn.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DateUtilsTest {

    private final DateUtils utils = new DateUtils();

    @Nested
    @DisplayName("isLeapYear()")
    class IsLeapYearTests {

        @Test
        @DisplayName("2020 is a leap year")
        void leapYear_2020_true() {
            assertTrue(utils.isLeapYear(2020));
        }

        @Test
        @DisplayName("2021 is not a leap year")
        void nonleapYear_2021_false() {
            assertFalse(utils.isLeapYear(2021));
        }

        @Test
        @DisplayName("1900 is not a leap year (century non-leap)")
        void centuryNonLeap_1900_false() {
            assertFalse(utils.isLeapYear(1900));
        }

        @Test
        @DisplayName("2000 is a leap year (century leap)")
        void centuryLeap_2000_true() {
            assertTrue(utils.isLeapYear(2000));
        }

        @Test
        @DisplayName("Invalid year throws exception (year < 1)")
        void invalidYear_throws() {
            IllegalArgumentException ex = assertThrows(
                    IllegalArgumentException.class,
                    () -> utils.isLeapYear(0)
            );
            assertEquals("Year must be positive", ex.getMessage());
        }
    }

    @Nested
    @DisplayName("getMonthName()")
    class GetMonthName {
        @Test
        @DisplayName("Month 1 is January")
        void month1_january() {
            assertEquals("January", utils.getMonthName(1));
        }

        @Test
        @DisplayName("Month 2 is February")
        void month2_february() {
            assertEquals("February", utils.getMonthName(2));
        }

        @Test
        @DisplayName("Month 3 is March")
        void month3_march() {
            assertEquals("March", utils.getMonthName(3));
        }

        @Test
        @DisplayName("Month 4 is April")
        void month4_april() {
            assertEquals("April", utils.getMonthName(4));
        }

        @Test
        @DisplayName("Month 5 is May")
        void month5_may() {
            assertEquals("May", utils.getMonthName(5));
        }

        @Test
        @DisplayName("Month 6 is June")
        void month6_june() {
            assertEquals("June", utils.getMonthName(6));
        }

        @Test
        @DisplayName("Month 7 is July")
        void month7_july() {
            assertEquals("July", utils.getMonthName(7));
        }

        @Test
        @DisplayName("Month 8 is August")
        void month8_august() {
            assertEquals("August", utils.getMonthName(8));
        }

        @Test
        @DisplayName("Month 9 is September")
        void month9_september() {
            assertEquals("September", utils.getMonthName(9));
        }

        @Test
        @DisplayName("Month 10 is October")
        void month10_october() {
            assertEquals("October", utils.getMonthName(10));
        }

        @Test
        @DisplayName("Month 11 is November")
        void month11_november() {
            assertEquals("November", utils.getMonthName(11));
        }

        @Test
        @DisplayName("Month 12 is December")
        void month12_december() {
            assertEquals("December", utils.getMonthName(12));
        }

        @Test
        @DisplayName("Invalid month 0 throws exception")
        void invalid_0month() {
            IllegalArgumentException ex = assertThrows(
                    IllegalArgumentException.class,
                    () -> utils.getMonthName(0)
            );
            assertEquals("Month must be between 1 and 12", ex.getMessage());
        }

        @Test
        @DisplayName("Invalid month 13 throws exception")
        void invalid_13month(){
            IllegalArgumentException ex = assertThrows(
                    IllegalArgumentException.class,
                    () -> utils.getMonthName(13)
            );
            assertEquals("Month must be between 1 and 12", ex.getMessage());
        }
    }

    @Nested
    @DisplayName("getDayOfYear()")
    class  GetDayOfYear {

        @Test
        @DisplayName("January 1st is day 1 of the year")
        void Jan1_isDay1() {
            assertEquals(1, utils.getDayOfYear(1, 1, 2021));
        }

        @Test
        @DisplayName("December 31st (non-leap year) is day 365")
        void dec31_nonLeap_is365() {
            assertEquals(365, utils.getDayOfYear(31,12,2021));
        }

        @Test
        @DisplayName("December 31st (leap year) is day 365")
        void dec31_Leap_is365() {
            assertEquals(366, utils.getDayOfYear(31,12,2020));
        }

        @Test
        @DisplayName("Leap year February 29th is day 60")
        void feb29_leap_is60() {
            assertEquals(60, utils.getDayOfYear(29, 2, 2020));
        }

        @Test
        @DisplayName("Invalid day throws exception")
        void invalidDay() {
            IllegalArgumentException ex = assertThrows(
                    IllegalArgumentException.class,
                    () -> utils.getDayOfYear(0,1,2021)
            );
            assertEquals("Invalid day", ex.getMessage());
        }

        @Test
        @DisplayName("Invalid month throws exception")
        void invalidMonth() {
            IllegalArgumentException ex = assertThrows(
                    IllegalArgumentException.class,
                    () -> utils.getDayOfYear(1,0,2021)
            );
            assertEquals("Invalid month", ex.getMessage());
        }
    }
}
