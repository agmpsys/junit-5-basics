package com.lanoqo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeEach
    public void init() {
        mathUtils = new MathUtils();
    }

    @Test
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

}