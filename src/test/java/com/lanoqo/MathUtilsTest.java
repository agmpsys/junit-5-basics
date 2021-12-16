package com.lanoqo;

import static org.junit.jupiter.api.Assumptions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


@TestInstance(TestInstance.Lifecycle.PER_METHOD) //By default
class MathUtilsTest {

    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    static void beforeAllInit() {
        System.out.println("This need to run before all");
    }

    @BeforeEach
    public void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
        testReporter.publishEntry("key", "Running " + testInfo.getDisplayName() + "with tags " + testInfo.getTags());
    }

    @AfterEach
    void cleanUp() {
        System.out.println("Cleanning up...");
    }

    @Nested
    @DisplayName("Add method")
    @Tag("Math")
    class AddTest {
        @Test
        @DisplayName("Testig ADD method for positive")
        void testAddPositive() {
            int expected = mathUtils.add(8,2);
            int actual = 10;

            assertEquals(actual, expected, () -> "Should return right sum");
        }

        @Test
        @DisplayName("Testig ADD method for positive")
        void testAddNegative() {
            int expected = mathUtils.add(8,-2);
            int actual = 6;

            assertEquals(actual, expected, () -> "Should return right sum");
        }
    }


    @Test
    void testDivedeZeroException() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0), () -> "Divide by zero should throw and exception");
    }

    @RepeatedTest(3)
    void testgetCircleArea() {
        double expected = mathUtils.getCircleArea(10);
        double actual = 314.15926535897932384626433832795;
        assertEquals(actual, expected, () -> "Get circle area from a radius input.");
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
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0), () -> "Divide by zero should throw and exception");
    }

    @Test
    void testDivedeZeroExceptionAssume() {
        boolean isServerUp = false;
        assumeTrue(isServerUp);
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0), () -> "Divide by zero should throw and exception");
    }

    @Test
    @Tag("Math")
    @DisplayName("Multiply method")
    void testMultiply() {
        //System.out.println("Running " + testInfo.getDisplayName() + "with tags " + testInfo.getTags());
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + "with tags " + testInfo.getTags());
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2,2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-2, mathUtils.multiply(2, -1))
                );
    }

}