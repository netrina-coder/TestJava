package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TabulateTest {
    Tabulate tab;

    @BeforeEach
    void setUp() {
        tab = new Tabulate();
    }

    @Test
    void function() {
        double exp = 12.6014199;
        double result = tab.function(-1, 1.5);
        assertEquals(exp, result, 1.0e-4);
    }

    @Test
    void functionTest2() {
        double exp2 = 1.67609;
        double result = tab.function(1, 1.5);
        assertEquals(exp2, result, 1.0e-4);
    }

    @Test
    void calculateStepCount() {
        double exp3 = 901;
        double result = tab.calculateStepCount(0.1, 1, 0.001);
        assertEquals(exp3, result, 1.0e-4);
    }

    @Test
    void calculateAverage() {
        double[] array = {1, 2, 3, 4, 5};
        double exp4 = 3;
        double result = tab.calculateAverage(array);
        assertEquals(exp4, result, 1.0e-4);
    }

    @Test
    void calculateSum() {
        double[] array = {1, 2, 3, 4, 5};
        double exp4 = 15;
        double result = tab.calculateSum(array);
        assertEquals(exp4, result, 1.0e-4);
    }


    @ParameterizedTest
    @CsvSource({"0, 0.1", "200, 0.3 ", "900, 1"})
    void createYArray(int index, double exp5) {
        double b = 1.5;
        double start = 0.1;
        double end = 1.0;
        double step = 0.001;
        double[] xArray = tab.createXArray(start, end, step);
        //double [] result = tab.createYArray(b, xArray);
        assertEquals(exp5, xArray[index], 0.001);

    }
    @ParameterizedTest
    @CsvSource({"0, -0.0011", "200, 0.10321 ", "900, 1.67609"})
    void createXArray(int index, double exp5) {
        double b = 1.5;
        double start = 0.1;
        double end = 1.0;
        double step = 0.001;
        double[] xArray = tab.createXArray(start, end, step);
        double [] yArray = tab.createYArray(b, xArray);
        assertEquals(exp5, yArray[index], 0.001);

    }
}