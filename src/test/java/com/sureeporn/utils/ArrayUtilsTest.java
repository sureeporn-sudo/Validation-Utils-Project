package com.sureeporn.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ArrayUtils Unit Tests")
public class ArrayUtilsTest {

    private final ArrayUtils utils = new ArrayUtils();

    @Nested
    @DisplayName("findMax()")
    class FindMaxTests {

        @Test
        @DisplayName("findMax returns max for normal array")
        void findMax_normalArray() {
            assertEquals(9, utils.findMax(new int[]{1, 9, 3, 7}));
        }

        @Test
        @DisplayName("findMax returns value when all values are same")
        void findMax_allSameValues() {
            assertEquals(5, utils.findMax(new int[]{5, 5, 5}));
        }

        @Test
        @DisplayName("findMax works with negative numbers")
        void findMax_negativeNumbers() {
            assertEquals(-2, utils.findMax(new int[]{-10, -2, -30}));
        }

        @Test
        @DisplayName("findMax works with single element array")
        void findMax_singleElement() {
            assertEquals(42, utils.findMax(new int[]{42}));
        }

        @Test
        @DisplayName("findMax throws IllegalArgumentException for null array")
        void findMax_nullArray_throws() {
            IllegalArgumentException ex = assertThrows(
                    IllegalArgumentException.class,
                    () -> utils.findMax(null)
            );
            assertEquals("Array cannot be null or empty", ex.getMessage());
        }

        @Test
        @DisplayName("findMax throws IllegalArgumentException for empty array")
        void findMax_emptyArray_throws() {
            IllegalArgumentException ex = assertThrows(
                    IllegalArgumentException.class,
                    () -> utils.findMax(new int[]{})
            );
            assertEquals("Array cannot be null or empty", ex.getMessage());
        }
    }

    @Nested
    @DisplayName("findMin()")
    class FindMinTests {

        @Test
        @DisplayName("findMin returns min for normal array")
        void findMin_normalArray() {
            assertEquals(1, utils.findMin(new int[]{1, 9, 3, 7}));
        }

        @Test
        @DisplayName("findMin returns value when all values are same")
        void findMin_allSameValues() {
            assertEquals(5, utils.findMin(new int[]{5, 5, 5}));
        }

        @Test
        @DisplayName("findMin works with negative numbers")
        void findMin_negativeNumbers() {
            assertEquals(-30, utils.findMin(new int[]{-10, -2, -30}));
        }

        @Test
        @DisplayName("findMin works with single element array")
        void findMin_singleElement() {
            assertEquals(42, utils.findMin(new int[]{42}));
        }

        @Test
        @DisplayName("findMin throws IllegalArgumentException for null array")
        void findMin_nullArray_throws() {
            IllegalArgumentException ex = assertThrows(
                    IllegalArgumentException.class,
                    () -> utils.findMin(null)
            );
            assertEquals("Array cannot be null or empty", ex.getMessage());
        }

        @Test
        @DisplayName("findMin throws IllegalArgumentException for empty array")
        void findMin_emptyArray_throws() {
            IllegalArgumentException ex = assertThrows(
                    IllegalArgumentException.class,
                    () -> utils.findMin(new int[]{})
            );
            assertEquals("Array cannot be null or empty", ex.getMessage());
        }
    }

    @Nested
    @DisplayName("average()")
    class AverageTests {

        @Test
        @DisplayName("Average returns correct value for normal array")
        void average_normalArray() {
            assertEquals(2.5, utils.average(new int[]{1, 2, 3, 4}), 0.00001);
        }

        @Test
        @DisplayName("average returns 0.0 when all values are zero")
        void average_allZeros() {
            assertEquals(0.0, utils.average(new int[]{0, 0, 0}), 0.00001);
        }

        @Test
        @DisplayName("average works with negative numbers")
        void average_negativeNumbers() {
            assertEquals(-5.0, utils.average(new int[]{-10, 0}), 0.00001);
        }

        @Test
        @DisplayName("Average throws IllegalArgumentException for null array")
        void Average_nullArray_throws() {
            IllegalArgumentException ex = assertThrows(
                    IllegalArgumentException.class,
                    () -> utils.average(null)
            );
            assertEquals("Array cannot be null or empty", ex.getMessage());
        }

        @Test
        @DisplayName("Array throws IllegalArgumentException for empty array")
        void Average_emptyArray_throws() {
            IllegalArgumentException ex = assertThrows(
                    IllegalArgumentException.class,
                    () -> utils.average(new int[]{})
            );
            assertEquals("Array cannot be null or empty", ex.getMessage());
        }
    }

    @Nested
    @DisplayName("reverse()")
    class ReverseTests {

        @Test
        @DisplayName("reverse returns reversed array for normal array")
        void reverse_normalArray() {
            assertArrayEquals(new int[]{4, 3, 2, 1}, utils.reverse(new int[]{1, 2, 3, 4}));
        }

        @Test
        @DisplayName("reverse works with single element array")
        void reverse_singleArray() {
            assertArrayEquals(new int[]{44}, utils.reverse(new int[]{44}));
        }

        @Test
        @DisplayName("reverse returns empty array for empty array input")
        void reverse_emptyArray() {
            assertArrayEquals(new int[]{}, utils.reverse(new int[]{}));
        }

        @Test
        @DisplayName("reverse returns null  for null array input")
        void reverse_nullArray() {
            assertNull(utils.reverse(null));
        }
    }

    @Nested
    @DisplayName("contains()")
    class ContainsTests {

        @Test
        @DisplayName("contains returns true when value exists")
        void contains_valueExists() {
            assertTrue(utils.contains(new int[]{1,2,3}, 2));
        }

        @Test
        @DisplayName("contains returns false when value does not exist")
        void contains_valueDoesNotExists() {
            assertFalse(utils.contains(new int[]{1,2,3}, 4));
        }

        @Test
        @DisplayName("contains returns false for null array")
        void contains_null() {
            assertFalse(utils.contains(null,1));
        }

        @Test
        @DisplayName("contains returns false for empty array")
        void contains_empty() {
            assertFalse(utils.contains(new int[]{}, 1));
        }
    }
}
