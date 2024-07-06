package ru.list.surkovr.algorithms.sortAlgorithms;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTest {

    @Test
    void sort() {
        int[] src = new int[] {4, 3, 2, 5, 4, 3, 5, 1, 0, 2, 5};
        int[] expected = new int[] {0, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5};
        Assertions.assertThat(CountingSort.sort(src)).isSorted().isEqualTo(expected);
    }
}