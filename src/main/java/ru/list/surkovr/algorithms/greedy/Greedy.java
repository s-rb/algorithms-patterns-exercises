package ru.list.surkovr.algorithms.greedy;

import java.util.Arrays;

public class Greedy {

    /**
     * 2037. Minimum Number of Moves to Seat Everyone
     * Easy
     * Topics
     * Companies
     * Hint
     * There are n availabe seats and n students standing in a room. You are given an array seats of length n, where seats[i] is the position of the ith seat. You are also given the array students of length n, where students[j] is the position of the jth student.
     *
     * You may perform the following move any number of times:
     *
     * Increase or decrease the position of the ith student by 1 (i.e., moving the ith student from position x to x + 1 or x - 1)
     * Return the minimum number of moves required to move each student to a seat such that no two students are in the same seat.
     *
     * Note that there may be multiple seats or students in the same position at the beginning.
     *
     *
     *
     * Example 1:
     *
     * Input: seats = [3,1,5], students = [2,7,4]
     * Output: 4
     * Explanation: The students are moved as follows:
     * - The first student is moved from from position 2 to position 1 using 1 move.
     * - The second student is moved from from position 7 to position 5 using 2 moves.
     * - The third student is moved from from position 4 to position 3 using 1 move.
     * In total, 1 + 2 + 1 = 4 moves were used.
     * Example 2:
     *
     * Input: seats = [4,1,5,9], students = [1,3,2,6]
     * Output: 7
     * Explanation: The students are moved as follows:
     * - The first student is not moved.
     * - The second student is moved from from position 3 to position 4 using 1 move.
     * - The third student is moved from from position 2 to position 5 using 3 moves.
     * - The fourth student is moved from from position 6 to position 9 using 3 moves.
     * In total, 0 + 1 + 3 + 3 = 7 moves were used.
     * Example 3:
     *
     * Input: seats = [2,2,6,6], students = [1,3,2,6]
     * Output: 4
     * Explanation: Note that there are two seats at position 2 and two seats at position 6.
     * The students are moved as follows:
     * - The first student is moved from from position 1 to position 2 using 1 move.
     * - The second student is moved from from position 3 to position 6 using 3 moves.
     * - The third student is not moved.
     * - The fourth student is not moved.
     * In total, 1 + 3 + 0 + 0 = 4 moves were used.
     *
     *
     * Constraints:
     *
     * n == seats.length == students.length
     * 1 <= n <= 100
     * 1 <= seats[i], students[j] <= 100
     */
    public int minMovesToSeat(int[] seats, int[] students) {
        int res = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for (int i = 0; i < seats.length; i++) res += Math.abs(seats[i] - students[i]);
        return res;
    }

    // https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/
    public int minMovesToSeat2(int[] seats, int[] students) {
        int[] diff = new int[Math.max(getMax(seats), getMax(students))];

        int len = seats.length;
        for (int i = 0; i < len; i++) {
            diff[seats[i]]++;
            diff[students[i]]--;
        }

        int res = 0;

        int unmatched = 0;
        for (int difference : diff) {
            res += Math.abs(unmatched);
            unmatched += difference;
        }
        return res;
    }

    private int getMax(int[] elements) {
        int max = 0;
        for (int el : elements) max = Math.max(max, el);
        return max;
    }

    /**
     * 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
     * Medium
     * Topics
     * Companies
     * Hint
     * A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros. For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
     *
     * Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so that they sum up to n.
     *
     *
     *
     * Example 1:
     *
     * Input: n = "32"
     * Output: 3
     * Explanation: 10 + 11 + 11 = 32
     * Example 2:
     *
     * Input: n = "82734"
     * Output: 8
     * Example 3:
     *
     * Input: n = "27346209830709182346"
     * Output: 9
     *
     *
     * Constraints:
     *
     * 1 <= n.length <= 105
     * n consists of only digits.
     * n does not contain any leading zeros and represents a positive integer.
     */
    public static int minPartitions(String n) {
        char max = '0';
        for (char c : n.toCharArray()) {
            max = c > max ? c : max;
            if (max == '9') break;
        }
        return Character.getNumericValue(max);
    }

    public static int minPartitions2(String n) {
        for (int i = 9; i >=0; i--) {
            if (n.contains(String.valueOf(i))) return i;
        }
        return 0;
    }
}
