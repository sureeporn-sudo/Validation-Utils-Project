# Validation Utils Project — Java

This repository contains a Java utility library called **ValidationUtils**, along with a comprehensive suite of **JUnit 5 unit tests** to ensure the correctness of each method.

The project was developed as part of an object-oriented programming / software testing assignment. It focuses on validating common input patterns and demonstrates fundamental testing practices such as edge case handling and exception verification.

---
## 📦 Project Structure

Validation-Utils-Project-Java/
├─ src/
│ ├─ main/java/com/sureeporn/utils
│ │ └─ ValidationUtils.java
│ └─ test/java/com/sureeporn/utils
│ └─ ValidationUtilsTest.java
├─ pom.xml
└─ README.md

---

## 🛠️ ValidationUtils Features

The `ValidationUtils` class provides helper methods to validate user input commonly encountered in web forms and applications:

### 🔹 `isValidEmail(String email)`
Checks whether a given string is a valid email address format.

### 🔹 `isValidPassword(String password)`
Validates a password according to the following rules:
- At least 8 characters
- Contains at least one uppercase letter
- Contains at least one lowercase letter
- Contains at least one digit

### 🔹 `isValidPhoneNumber(String phone)`
Validates North American phone number formats:
- `123-456-7890`
- `(123) 456-7890`
- `1234567890`

### 🔹 `isValidZipCode(String zipCode)`
Checks if the input is a valid US ZIP code:
- 5-digit (e.g. `12345`)
- 9-digit ZIP+4 (e.g. `12345-6789`)

---

## 📑 Running the Unit Tests

This project uses **JUnit 5** for testing. The test suite covers normal scenarios, edge cases, and invalid input handling.

Ensure you have **Maven** and at least **Java 17** installed.

To run all tests, use:

```bash
mvn clean test
```

You should see output similar to:
```bash
Tests run: XX, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

## 📌 Example Validations

Here are some examples of how to use the utility methods:

```bash
ValidationUtils utils = new ValidationUtils();

// Email
assertTrue(utils.isValidEmail("john.doe@example.com"));
assertFalse(utils.isValidEmail("john@"));

// Password
assertTrue(utils.isValidPassword("Abc12345"));
assertFalse(utils.isValidPassword("password"));

// Phone
assertTrue(utils.isValidPhoneNumber("123-456-7890"));
assertFalse(utils.isValidPhoneNumber("123456"));

// ZIP Code
assertTrue(utils.isValidZipCode("12345-6789"));
assertFalse(utils.isValidZipCode("ABCDE"));
```
---

## 🧪 Why This Matters
This project demonstrates:
- How to design reusable validation utilities
- How to write comprehensive unit tests
- How to handle edge cases and invalid input
- Good practices for code organization with Maven
