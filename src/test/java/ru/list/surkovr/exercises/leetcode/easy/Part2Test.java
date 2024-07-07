package ru.list.surkovr.exercises.leetcode.easy;

import org.junit.jupiter.api.Test;
import ru.list.surkovr.exercises.leetcode.easy.Part2;

import static org.assertj.core.api.Assertions.assertThat;

class Part2Test {

    @Test
    void reverseInt() {
        final int actual = Part2.reverseInt(-321);
        assertThat(actual).isEqualTo(-123);
    }

    @Test
    void plusOne() {
        int[] actual = Part2.plusOne(new int[]{9});
        assertThat(actual).isEqualTo(new int[]{1, 0});
    }
}