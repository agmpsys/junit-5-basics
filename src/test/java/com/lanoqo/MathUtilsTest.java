package com.lanoqo;

import static org.junit.jupiter.api.Assumptions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


@TestInstance(TestInstance.Lifecycle.PER_METHOD) //By default
class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeAll
    static void beforeAllInit() {
        System.out.println("This need to run before all");
    }

    @BeforeEach
    public void init() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanUp() {
        System.out.println("Cleanning up...");
    }

    @Test
    @DisplayName("Testig ADD method")
    void testAdd() {
        int expected = mathUtils.add(8,2);
        int actual = 10;

        assertEquals(actual, expected);
    }

    @Test
    void testDivedeZeroException() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0), "Divide by zero should throw and exception");
    }

    @Test
    void testgetCircleArea() {
        double expected = mathUtils.getCircleArea(10);
        double actual = 314.15926535897932384626433832795;
        assertEquals(actual, expected, "Get circle area from a radius input.");
    }

    @Test
    @DisplayName("TDD method, do not need to run")
    @Disabled("Work in progress")
    void testDisabled() {
        fail();
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testDivedeZeroExceptionLinux() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0), "Divide by zero should throw and exception");
    }

    @Test

    void testDivedeZeroExceptionAssume() {
        boolean isServerUp = false;
        assumeTrue(isServerUp);
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0), "Divide by zero should throw and exception");
    }

    @Test
    @DisplayName("Multiply method")
    void testMultiply() {
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2,2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-2, mathUtils.multiply(2, -1))
                );
    }

}