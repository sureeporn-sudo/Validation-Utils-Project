package com.sureeporn.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("ValidationUtils Unit Tests")
public class ValidationUtilsTest {

    private final ValidationUtils utils = new ValidationUtils();

    @Nested
    @DisplayName("isValidEmail()")
    class EmailTests {

        @Test
        @DisplayName("Valid email returns true")
        void Validemail_true() {
            assertTrue(utils.isValidEmail("john@example.com"));
        }

        @Test
        @DisplayName("Email missing domain returns false")
        void missingDomain_false() {
            assertFalse(utils.isValidEmail("john@"));
        }

        @Test
        @DisplayName("Email missing @ returns false")
        void missingAt_false() {
            assertFalse(utils.isValidEmail("johnexample.com"));
        }

        @Test
        @DisplayName("Null email returns false")
        void nullEmail_false() {
            assertFalse(utils.isValidEmail(null));
        }

        @Test
        @DisplayName("Empty email returns false")
        void emptyEmail_false() {
            assertFalse(utils.isValidEmail(""));
        }

        @Test
        @DisplayName("Email with special characters allowed returns true")
        void specialCharacters_true() {
            assertTrue(utils.isValidEmail("a+b_c.d-e@sub.example.co"));
        }
    }

    @Nested
    @DisplayName("isValidPassword()")
    class PasswordTests {

        @Test
        @DisplayName("Valid password returns true (8+ chars, upper, lower, digit)")
        void validPassword_true() {
            assertTrue(utils.isValidPassword("Abcdefg1"));
        }

        @Test
        @DisplayName("Too short password returns false")
        void tooShort_false() {
            assertFalse(utils.isValidPassword("Abc1def")); // 7 chars
        }

        @Test
        @DisplayName("Password missing uppercase returns false")
        void missingUppercase_false() {
            assertFalse(utils.isValidPassword("abcdefg1"));
        }

        @Test
        @DisplayName("Password missing lowercase returns false")
        void missingLowercase_false() {
            assertFalse(utils.isValidPassword("ABCDEFG1"));
        }

        @Test
        @DisplayName("Password missing digit returns false")
        void missingDigit_false() {
            assertFalse(utils.isValidPassword("Abcdefgh"));
        }

        @Test
        @DisplayName("Null password returns false")
        void nullPassword_false() {
            assertFalse(utils.isValidPassword(null));
        }
    }

    @Nested
    @DisplayName("isValidPhoneNumber()")
    class PhoneTests {

        @Test
        @DisplayName("Valid phone format 123-456-7890 returns true")
        void validFormat_dashes_true() {
            assertTrue(utils.isValidPhoneNumber("123-456-7890"));
        }

        @Test
        @DisplayName("Valid phone format (123) 456-7890 returns true")
        void validFormat_parentheses_true() {
            assertTrue(utils.isValidPhoneNumber("(123) 456-7890"));
        }

        @Test
        @DisplayName("Valid phone format 1234567890 returns true")
        void validFormat_digitsOnly_true() {
            assertTrue(utils.isValidPhoneNumber("1234567890"));
        }

        @Test
            @DisplayName("Invalid phone format returns false")
            void invalidFormat_false() {
                assertFalse(utils.isValidPhoneNumber("123.456.7890"));
            }

        @Test
        @DisplayName("Too short phone number returns false")
        void tooShort_false() {
            assertFalse(utils.isValidPhoneNumber("123456789"));
        }

        @Test
        @DisplayName("Too long phone number returns false")
        void tooLong_false() {
            assertFalse(utils.isValidPhoneNumber("12345678901"));
        }

        @Test
        @DisplayName("Null phone number returns false")
        void nullPhone_false() {
            assertFalse(utils.isValidPhoneNumber(null));
        }
    }

    @Nested
    @DisplayName("isValidZipCode()")
    class ZipCodeTests {

        @Test
        @DisplayName("Valid 5-digit zip code returns true")
        void zip5_true() {
            assertTrue(utils.isValidZipCode("12345"));
        }

        @Test
        @DisplayName("Valid 9-digit zip code (ZIP+4) returns true")
        void zip9_true() {
            assertTrue(utils.isValidZipCode("12345-6789"));
        }

        @Test
        @DisplayName("Invalid zip code format returns false")
        void invalidZip_false() {
            assertFalse(utils.isValidZipCode("12-345"));
        }

        @Test
        @DisplayName("Null zip code returns false")
        void nullZip_false() {
            assertFalse(utils.isValidZipCode(null));
        }
    }
}

