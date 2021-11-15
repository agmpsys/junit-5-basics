package com.lanoqo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void test() {
        MathUtils mathUtils = new MathUtils();
        int expected = mathUtils.add(8,2);
        int actual = 10;

        assertEquals(actual, expected);
    }

    @Test
    void testgetCircleArea() {
        MathUtils mathUtils = new MathUtils();
        double expected = mathUtils.getCircleArea(10);
        double actual = 314.15926535897932384626433832795;
        assertEquals(actual, expected, "Get circle area from a radius input.");
    }

}