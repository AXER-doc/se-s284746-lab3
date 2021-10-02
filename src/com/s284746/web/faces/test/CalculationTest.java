package com.s284746.web.faces.test;

import com.s284746.web.faces.util.Calculation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CalculationTest {
    @Test
    public void testFunction() {
        Assertions.assertEquals(true, Calculation.belongsToArea(-2, 0, 2));
    }
}
