package ru.list.surkovr.exercises.leetcode.easy;


import java.util.logging.Logger;

public class Part2 {

    /*
    Reverse integer
    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value
    to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
    */
    public static int reverseInt(int x) {
        int reversed = 0;
        while (x != 0) {
            try {
                reversed = Math.addExact(Math.multiplyExact(reversed, 10), x % 10);
            } catch (ArithmeticException e) {
                return 0;
            }
            x = x / 10;
        }
        return reversed;
    }

    /**
     * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
     *
     * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
     *
     * You may assume the integer does not contain any leading zero, except the number 0 itself.
     */
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean hasToAdd = true;
        for (int i = len - 1; i >= 0; i--) {
            if (!hasToAdd) {
                continue;
            }
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                hasToAdd = false;
            }
        }
        if (hasToAdd) {
            int[] result = new int[len + 1];
            for (int i = len - 1, j = len; i >= 0; i--, j--) {
                result[j] = digits[i];
            }
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
