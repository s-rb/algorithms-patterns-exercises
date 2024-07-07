package ru.list.surkovr.exercises.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import ru.list.surkovr.exercises.leetcode.medium.Part1;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.util.Lists.list;
import static ru.list.surkovr.exercises.leetcode.medium.Part1.CombinationIterator;
import static ru.list.surkovr.exercises.leetcode.medium.Part1.CombinationIterator2;


public class Part1Test {

    @Test
    void testIterator() {
        CombinationIterator itr = new CombinationIterator("abc", 2);
        Assertions.assertThat(itr.next()).isEqualTo("ab");
        Assertions.assertThat(itr.hasNext()).isTrue();
        Assertions.assertThat(itr.next()).isEqualTo("ac");
        Assertions.assertThat(itr.hasNext()).isTrue();
        Assertions.assertThat(itr.next()).isEqualTo("bc");
        Assertions.assertThat(itr.hasNext()).isFalse();
    }

    @Test
    void testIterator2() {
        CombinationIterator itr = new CombinationIterator("abcd", 3);
        Assertions.assertThat(itr.next()).isEqualTo("abc");
        Assertions.assertThat(itr.hasNext()).isTrue();
        Assertions.assertThat(itr.next()).isEqualTo("abd");
        Assertions.assertThat(itr.hasNext()).isTrue();
        Assertions.assertThat(itr.next()).isEqualTo("acd");
    }

    @Test
    void testIterator3() {
        CombinationIterator2 itr = new CombinationIterator2("abc", 2);
        Assertions.assertThat(itr.next()).isEqualTo("ab");
        Assertions.assertThat(itr.hasNext()).isTrue();
        Assertions.assertThat(itr.next()).isEqualTo("ac");
        Assertions.assertThat(itr.hasNext()).isTrue();
        Assertions.assertThat(itr.next()).isEqualTo("bc");
        Assertions.assertThat(itr.hasNext()).isFalse();
    }

    @Test
    void testIterator4() {
        CombinationIterator2 itr = new CombinationIterator2("bvwz", 2);
        Assertions.assertThat(itr.next()).isEqualTo("bv");
        Assertions.assertThat(itr.hasNext()).isTrue();
        Assertions.assertThat(itr.next()).isEqualTo("bw");
        Assertions.assertThat(itr.hasNext()).isTrue();
        Assertions.assertThat(itr.next()).isEqualTo("bz");
    }

    @Test
    void numTilePossibilities() {
        final int res = Part1.numTilePossibilities("AAB");
        Assertions.assertThat(res).isEqualTo(8);
    }

    @Test
    void numTilePossibilities2() {
        final int res = Part1.numTilePossibilities("AAABBC");
        Assertions.assertThat(res).isEqualTo(188);
    }

    @Test
    void numTilePossibilities2test() {
        final int res = Part1.numTilePossibilities2("AAABBC");
        Assertions.assertThat(res).isEqualTo(188);
    }

    @Test
    void permute() {
        final List<List<Integer>> res = Part1.permute(new int[]{1, 2, 3});
        Assertions.assertThat(res).isNotNull().isNotEmpty()
                .containsExactlyInAnyOrderElementsOf(Lists.list(
                        list(1, 2, 3),
                        list(1, 3, 2),
                        list(2, 1, 3),
                        list(2, 3, 1),
                        list(3, 1, 2),
                        list(3, 2, 1)
                        )
                );
    }

    @Test
    void letterCasePermutation() {
        final List<String> res = Part1.letterCasePermutation("a1b2");
        Assertions.assertThat(res).isNotNull().isNotEmpty()
                .containsExactlyInAnyOrderElementsOf(Arrays.asList("a1b2","a1B2","A1b2","A1B2"));
    }

    @Test
    void partition() {
        final List<List<String>> res = Part1.partition("aab");
        Assertions.assertThat(res).isNotNull().isNotEmpty()
                .containsExactlyInAnyOrderElementsOf(List.of(
                        List.of("a","a","b"),List.of("aa","b")
                ));
    }

    @Test
    void countMaxOrSubsets() {
        final int res = Part1.countMaxOrSubsets(new int[]{3, 1});
        Assertions.assertThat(res).isEqualTo(2);
    }

    @Test
    void sequentialDigits() {
        Assertions.assertThat(Part1.sequentialDigits(100, 300)).isNotNull().isNotEmpty()
            .containsExactlyInAnyOrderElementsOf(List.of(123, 234));
        Assertions.assertThat(Part1.sequentialDigits(1000, 13000)).isNotNull().isNotEmpty()
            .containsExactlyInAnyOrderElementsOf(List.of(1234,2345,3456,4567,5678,6789,12345));
    }

    @Test
    void maximumEvenSplit() {
        Part1.maximumEvenSplit(28);
    }

    @Test
    void countArrangement() {
        Part1.countArrangement(2);
    }
}
