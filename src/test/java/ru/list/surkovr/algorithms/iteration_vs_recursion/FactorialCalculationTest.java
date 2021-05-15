package ru.list.surkovr.algorithms.iteration_vs_recursion;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialCalculationTest {

    @Test
    public void calculateFactorial() {
        int initValue = 5;
        long actual = FactorialCalculation.calculateIterative(initValue);
        long expected = 120;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateFactorialRec() {
        int initValue = 6;
        long actual = FactorialCalculation.calculateRecursive(initValue);
        long expected = 720;
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
