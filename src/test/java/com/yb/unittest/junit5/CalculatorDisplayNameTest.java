package com.yb.unittest.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Calculator Display test")		// Sınıf adı yerine yazılır.
public class CalculatorDisplayNameTest {

    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("Pozitif sayılar toplanınca pozitif çıkar")  // Metod adı yerine yazılır.
    public void testPozitifSayilarToplanincaPozitifCikar() {
        int result = calculator.topla(4, 8);
        assertEquals(12, result);
    }

    @Test
    public void testNegatifSayilarCarpilincaPozitifCikar() {
        int result = calculator.carp(-5, -8);
        assertEquals(40, result);
    }
}
