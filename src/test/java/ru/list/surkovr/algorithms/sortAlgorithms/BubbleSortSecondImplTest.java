package ru.list.surkovr.algorithms.sortAlgorithms;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BubbleSortSecondImplTest {

    @Test
    public void sort() {
        int[] array = new int[]{1, 2, 6, 9, 3, 0, 4, 8, 5, 7};
        int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        BubbleSortSecondImpl.sort(array);
        Assertions.assertThat(array).containsExactly(expected);
    }
}
