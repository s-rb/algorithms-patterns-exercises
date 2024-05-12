package ru.list.surkovr.algorithms.sliding_window;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SlidingWindowTest {

    @Test
    void countGoodSubstrings() {
        Assertions.assertThat(SlidingWindow.countGoodSubstrings("xyzzaz")).isEqualTo(1);
        Assertions.assertThat(SlidingWindow.countGoodSubstrings("aababcabc")).isEqualTo(4);
    }

    @Test
    void countGoodSubstrings2() {
        Assertions.assertThat(SlidingWindow.countGoodSubstrings2("xyzzaz")).isEqualTo(1);
        Assertions.assertThat(SlidingWindow.countGoodSubstrings2("aababcabc")).isEqualTo(4);
        Assertions.assertThat(SlidingWindow.countGoodSubstrings2("owuxoelszb")).isEqualTo(8);
    }
    @Test
    void countGoodSubstrings3() {
        Assertions.assertThat(SlidingWindow.countGoodSubstrings3("xyzzaz")).isEqualTo(1);
        Assertions.assertThat(SlidingWindow.countGoodSubstrings3("aababcabc")).isEqualTo(4);
        Assertions.assertThat(SlidingWindow.countGoodSubstrings3("owuxoelszb")).isEqualTo(8);
    }

    @Test
    void longestSubarray() {
        Assertions.assertThat(SlidingWindow.longestSubarray(new int[]{1,1,0,1})).isEqualTo(3);
        Assertions.assertThat(SlidingWindow.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1})).isEqualTo(5);
    }
}
