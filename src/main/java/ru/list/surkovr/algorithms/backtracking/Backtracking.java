package ru.list.surkovr.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {

    /**
     * 401. Binary Watch
     * Easy
     * Topics
     * Companies
     * Hint
     * A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.
     *
     * For example, the below binary watch reads "4:51".
     *
     *
     * Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.
     *
     * The hour must not contain a leading zero.
     *
     * For example, "01:00" is not valid. It should be "1:00".
     * The minute must consist of two digits and may contain a leading zero.
     *
     * For example, "10:2" is not valid. It should be "10:02".
     *
     *
     * Example 1:
     *
     * Input: turnedOn = 1
     * Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
     * Example 2:
     *
     * Input: turnedOn = 9
     * Output: []
     *
     *
     * Constraints:
     *
     * 0 <= turnedOn <= 10
     */
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    list.add(String.format("%d:%02d", hour, minute));
                }
            }
        }
        return list;
    }

    /**
     * 1863. Sum of All Subset XOR Totals
     * Easy
     * Topics
     * Companies
     * Hint
     * The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.
     *
     * For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
     * Given an array nums, return the sum of all XOR totals for every subset of nums.
     *
     * Note: Subsets with the same elements should be counted multiple times.
     *
     * An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,3]
     * Output: 6
     * Explanation: The 4 subsets of [1,3] are:
     * - The empty subset has an XOR total of 0.
     * - [1] has an XOR total of 1.
     * - [3] has an XOR total of 3.
     * - [1,3] has an XOR total of 1 XOR 3 = 2.
     * 0 + 1 + 3 + 2 = 6
     * Example 2:
     *
     * Input: nums = [5,1,6]
     * Output: 28
     * Explanation: The 8 subsets of [5,1,6] are:
     * - The empty subset has an XOR total of 0.
     * - [5] has an XOR total of 5.
     * - [1] has an XOR total of 1.
     * - [6] has an XOR total of 6.
     * - [5,1] has an XOR total of 5 XOR 1 = 4.
     * - [5,6] has an XOR total of 5 XOR 6 = 3.
     * - [1,6] has an XOR total of 1 XOR 6 = 7.
     * - [5,1,6] has an XOR total of 5 XOR 1 XOR 6 = 2.
     * 0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28
     * Example 3:
     *
     * Input: nums = [3,4,5,6,7,8]
     * Output: 480
     * Explanation: The sum of all XOR totals for every subset is 480.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 12
     * 1 <= nums[i] <= 20
     */
    /**
     * решение через битмаск bitmask
     * Все комбинации цифр можно представить как маску 1 и 0 - число есть и нет
     * Количество комбнаций - 2 в степени n (число цифр)
     * [3, 5, 6] - 2 в степени 3 или 1 << 3 = 8
     * возможные комбинации
     * 000 == 0
     * 001 == 1
     * 010 == 2
     * 011 == 3
     * 100 == 4
     * 101 == 5
     * 110 == 6
     * 111 == 7
     *
     *
     * 001
     * 010
     * 100
     */
    public static int subsetXORSumBitMask(int[] nums) {
        int sum = 0;
        // iterate through all bit masks
        for (int i = 1; i < 1 << nums.length; i++) {
            int temp = 0;
            // iterate through all nums
            for (int j = 0; j < nums.length; j++) {
                // check if current bit is marked as 1, then do operation
                if ((i & (1 << j)) != 0) temp ^= nums[j];
            }
            sum += temp;
        }
        return sum;
    }

    private static int total;
    private static int end;
    private static int[] nums;
    public static int subsetXORSum(int[] src) {
        nums = src;
        end = nums.length;
        recurs(0, new ArrayList<>());
        return total;
    }

    private static void recurs(int start, List<Integer> list) {
        int temp = 0;
        for (int i=0;i<list.size();i++) temp^=list.get(i);
        total +=temp;

        for (int i =start; i<end; i++) {
            list.add(nums[i]);
            recurs(i+1,list);
            list.remove(list.size()-1);
        }
    }
}
