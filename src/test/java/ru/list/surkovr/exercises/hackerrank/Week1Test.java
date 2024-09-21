package ru.list.surkovr.exercises.hackerrank;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.list.surkovr.exercises.hackerrank.Week1.Result;

import java.util.Arrays;
import java.util.List;

import static ru.list.surkovr.exercises.hackerrank.Week1.*;

class Week1Test {

    @Test
    void testSortEvenOdd() {
        int[] result = sortEvenOdd(new int[]{4, 1, 2, 3});
        assertArrayEquals(new int[]{2, 3, 4, 1}, result);
    }

    @Test
    void testPlusMinus() {
        var a = 0.500000;
        var b = 0.333333;
        var c = 0.166667;
        assertEquals(Result.plusMinus(List.of(-4, 3, -9, 0, 4, 1)), String.format("%s\n%s\n%s", a, b, c));
        a = 0.400000;
        b = 0.400000;
        c = 0.200000;
        assertEquals(Result.plusMinus(List.of(1, 1, 0, -1, -1)), String.format("%s\n%s\n%s", a, b, c));
    }

    @Test
    void testMiniMaxSum() {
        assertEquals("10 14", miniMaxSum(List.of(1, 2, 3, 4, 5)));
        assertEquals("16 24", miniMaxSum(List.of(1, 3, 5, 7, 9)));
        assertEquals("2063136757 2744467344", miniMaxSum(List.of(256741038, 623958417, 467905213, 714532089, 938071625)));
    }

    @Test
    void testTimeConversion() {
        assertEquals("00:00:00", timeConversion("12:00:00AM"));
        assertEquals("12:00:00", timeConversion("12:00:00PM"));
        assertEquals("12:01:00", timeConversion("12:01:00PM"));
        assertEquals("00:01:00", timeConversion("12:01:00AM"));
        assertEquals("19:05:45", timeConversion("07:05:45PM"));
        assertEquals("06:40:03", timeConversion("06:40:03AM"));
        assertEquals("12:45:54", timeConversion("12:45:54PM"));
    }

    @Test
    void testBreakingRecords() {
        assertIterableEquals(List.of(1, 1), breakingRecords(List.of(12, 24, 10, 24)));
    }

    @Test
    void testDivisibleSumPairs() {
        assertEquals(3, divisibleSumPairs(6, 5, List.of(1, 2, 3, 4, 5, 6)));
        assertEquals(5, divisibleSumPairs(6, 3, List.of(1, 3, 2, 6, 1, 2)));
    }

    @Test
    void testMatchingStrings() {
        assertEquals(List.of(2, 1, 0), matchingStrings(List.of("aba", "baba", "aba", "xzxb"), List.of("aba", "xzxb", "ab")));
    }

    @Test
    void testFlippingBits() {
        assertEquals(2147483648L, flippingBits(2147483647));
    }

    @Test
    void testTwoArrays() {
        assertEquals("YES", twoArrays(10, Arrays.asList(2, 1, 3), Arrays.asList(7, 8, 9)));
        assertEquals("NO", twoArrays(5, Arrays.asList(1, 2, 2, 1), Arrays.asList(3, 3, 3, 4)));
    }

    @Test
    void testMaximumPerimeterTriangle() {
        List<Integer> result = maximumPerimeterTriangle(Arrays.asList(
                1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000
        ));
        assertEquals(List.of(-1), result);
    }

    @Test
    void testPickingNumbers() {
        assertEquals(3, pickingNumbers(Arrays.asList(4, 6, 5, 3, 3, 1)));
    }

    @Test
    void testSeparateNumbers() {
        assertEquals(separateNumbers("42949672954294967296429496729"), "NO");
    }

    @Test
    void testMinimumNumber() {
        assertEquals(1, minimumNumber(7, "AUzs-nV"));
    }

    @Test
    void testSansaXor() {
        assertEquals(0, sansaXor(Arrays.asList(4, 5, 7, 5)));
    }
}
