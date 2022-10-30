package com.yb.unittest.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("dev")
public class CalculatorExceptionTest {

    @Test
    public void testExceptions() {

        Calculator calculator = new Calculator();

        ArithmeticException exception = assertThrows(
                ArithmeticException.class, () -> calculator.bol(1, 0));

        assertEquals("/ by zero", exception.getMessage());
    }

}
