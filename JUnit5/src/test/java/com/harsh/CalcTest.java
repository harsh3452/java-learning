package com.harsh;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {

    @Test
    void testDivide() {
        Calc calc = new Calc();

        int actual = calc.divide(10, 5);
        int expected = 2;

            assertEquals(expected, actual);
    }
}