package br.edu.ifpe.tdd.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    double number1 = 3.0, number2 = 4.0,
            number3 = 5.0, number4 = 6.0;

    @Test
    @DisplayName("givenTwoNumbersWhenAddingThenCalculatesTheSumOfThesesNumbers")
    void sum() {
        assertEquals(7.0, Calculator.sum(number1, number2));    // 3+4 = 7
        assertEquals(11.0, Calculator.sum(number3, number4));   // 5+6 = 11
    }

    @Test
    @DisplayName("givenTwoNumbersWhenSubtractingThenCalculatesTheSubtractionOfThesesNumbers")
    void subtract() {
        assertEquals(1.0, Calculator.sub(number2, number1)); // 4-3 = 1
        assertEquals(3.0, Calculator.sub(number4, number1)); // 6-3 = 3
    }

    @Test
    @DisplayName("givenTwoNumbersWhenMultiplyingThenCalculatesTheMultiplicationOfThesesNumbers")
    void multiply(){
        assertEquals(20.0, Calculator.multiply(number3, number2)); // 4x5 = 20
        assertEquals(18.0, Calculator.multiply(number4, number1)); // 6x3 = 18
    }

    @Test
    @DisplayName("givenTwoNumbersWhenDividingThenCalculatesTheDivisionOfThesesNumbers")
    void divide(){
        assertEquals(2.0, Calculator.divide(number4, number1)); // 6/3 = 2
        assertEquals(1.5, Calculator.divide(number4, number2)); // 6/4 = 1.5
    }
}
