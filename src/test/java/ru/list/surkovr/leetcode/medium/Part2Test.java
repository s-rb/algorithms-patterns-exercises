package ru.list.surkovr.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Part2Test {

    @Test
    void getMaximumGold() {
        Assertions.assertEquals(24, Part2.getMaximumGold(new int[][]{
                {0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}
        }));
    }
}
