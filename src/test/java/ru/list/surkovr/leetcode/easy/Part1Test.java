package ru.list.surkovr.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.list.surkovr.leetcode.easy.Part1.*;

public class Part1Test {

    @Test
    public void getTwoSumTest() {
        int[] actual = getTwoSum(new int[]{3, 2, 4}, 6);
        int[] expected = {1, 2};
        assertThat(actual).isNotNull().containsExactlyInAnyOrder(expected);
    }

    @Test
    public void getLongestCommonPrefixTest() {
        String actual = longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        assertThat(actual).isEqualTo("fl");
    }

    @Test
    public void removeDuplicatesTest() {
        int actual = removeDuplicates(new int[]{1, 1, 2});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void romanToIntTest() {
        int actual = romanToInt("MCMXCIV");
        assertThat(actual).isEqualTo(1994);
    }

    @Test
    public void romanToInt2Test() {
        int actual = romanToInt2("MCMXCIV");
        assertThat(actual).isEqualTo(1994);
    }

    @Test
    public void isValidTest() {
        boolean actual = isValid("([)]");
        assertThat(actual).isFalse();
    }

    @Test
    public void isValidTest2() {
        boolean actual = isValid("{[]}");
        assertThat(actual).isTrue();
    }

    @Test
    public void interpretTest() {
        String actual = interpret("(al)G(al)()()G");
        assertThat(actual).isEqualTo("alGalooG");
    }

    @Test
    public void interpret2Test() {
        String actual = interpret2("(al)G(al)()()G");
        assertThat(actual).isEqualTo("alGalooG");
    }

    @Test
    public void removeDuplicatesStrTest() {
        String actual = removeDuplicates("abbaca");
        assertThat(actual).isEqualTo("ca");
    }

    @Test
    public void removeDuplicates2StrTest() {
        String actual = removeDuplicates2("abbaca");
        assertThat(actual).isEqualTo("ca");
    }

    @Test
    public void removeDuplicates3StrTest() {
        String actual = removeDuplicates3("abbaca");
        assertThat(actual).isEqualTo("ca");
    }

    @Test
    public void maximumWealthTest() {
        int actual = maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}});
        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void findLengthOfLCISTest() {
        int actual = findLengthOfLCIS(new int[]{1, 3, 5, 4, 7});
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void reverseWordsTest() {
        String actual = reverseWords("Let's take LeetCode contest");
        assertThat(actual).isEqualTo("s'teL ekat edoCteeL tsetnoc");
    }

    @Test
    public void reverseWords2Test() {
        String actual = reverseWords2("Let's take LeetCode contest");
        assertThat(actual).isEqualTo("s'teL ekat edoCteeL tsetnoc");
    }

    @Test
    public void reverseWords3Test() {
        String actual = reverseWords3("Let's take LeetCode contest");
        assertThat(actual).isEqualTo("s'teL ekat edoCteeL tsetnoc");
    }

    @Test
    public void sumOfLeftLeavesTest() {
        int actual = sumOfLeftLeaves(
                new TreeNode(3,
                        new TreeNode(9), new TreeNode(20,
                        new TreeNode(15), new TreeNode(7))
                ));
        assertThat(actual).isEqualTo(24);
    }

    @Test
    public void sumOfLeftLeaves2Test() {
        int actual = sumOfLeftLeaves2(
                new TreeNode(3,
                        new TreeNode(9), new TreeNode(20,
                        new TreeNode(15), new TreeNode(7))
                ));
        assertThat(actual).isEqualTo(24);
    }

    @Test
    public void reverseIntTest() {
        int actual = reverseInt(123);
        assertThat(actual).isEqualTo(321);
    }
}
