package ru.list.surkovr.algorithms.iteration_vs_recursion;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleCalculationTest {

    @Test
    public void calculateIterative() {
        int initValue = 5;
        long actual = TriangleCalculation.calculateIterative(initValue);
        long expected = 15;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateRecursive() {
        int initValue = 6;
        long actual = TriangleCalculation.calculateRecursive(initValue);
        long expected = 21;
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
