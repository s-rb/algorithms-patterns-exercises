package ru.list.surkovr.algorithms.iteration_vs_recursion;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PowerTest {

    @Test
    public void getPoweredTest() {
        int actual = Power.getPowered(2, 3);
        int expected = 8;
        Assertions.assertThat(actual).isNotNull().isEqualTo(expected);
    }
}
