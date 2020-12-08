package ru.list.surkovr.leetcode.easy;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part1 {

    private static final Logger LOGGER = Logger.getLogger(Part1.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "In getTwoSum found: "
                + Arrays.toString(getTwoSum(new int[]{3, 2, 4}, 6)));
        LOGGER.log(Level.INFO, "--------------------------------");
        LOGGER.log(Level.INFO, "In longestCommonPrefix found: "
                + longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        LOGGER.log(Level.INFO, "--------------------------------");
        LOGGER.log(Level.INFO, "In removeDuplicates found: " + removeDuplicates(new int[]{1,1,2}));
        LOGGER.log(Level.INFO, "--------------------------------");
        LOGGER.log(Level.INFO, "In romanToInt found: " + romanToInt("MCMXCIV"));
        LOGGER.log(Level.INFO, "--------------------------------");
        LOGGER.log(Level.INFO, "In romanToInt2 found: " + romanToInt2("MCMXCIV"));
        LOGGER.log(Level.INFO, "--------------------------------");
        LOGGER.log(Level.INFO, "In isValid found: " + isValid("([)]"));
        LOGGER.log(Level.INFO, "--------------------------------");
    }

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * <p>
     * You can return the answer in any order.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
     * Example 2:
     * <p>
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * Example 3:
     * <p>
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 2 <= nums.length <= 103
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * Only one valid answer exists.
     */
    private static int[] getTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result = new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return result;
    }

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     * <p>
     * If there is no common prefix, return an empty string "".
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     * <p>
     * Input: strs = ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 0 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] consists of only lower-case English letters.
     */
    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs == null || strs.length == 0 || strs[0].length() == 0) {
            return result;
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char currentChar = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    return result;
                }
                if (currentChar != strs[j].charAt(i)) {
                    return result;
                }
            }
            result = strs[0].substring(0, i + 1);
        }
        return result;
    }

    /**
     * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
     * <p>
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     * <p>
     * Clarification:
     * <p>
     * Confused why the returned value is an integer but your answer is an array?
     * <p>
     * Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.
     * <p>
     * Internally you can think of this:
     * <p>
     * // nums is passed in by reference. (i.e., without making a copy)
     * int len = removeDuplicates(nums);
     * <p>
     * // any modification to nums in your function would be known by the caller.
     * // using the length returned by your function, it prints the first len elements.
     * for (int i = 0; i < len; i++) {
     * print(nums[i]);
     * }
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,1,2]
     * Output: 2, nums = [1,2]
     * Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the returned length.
     * Example 2:
     * <p>
     * Input: nums = [0,0,1,1,1,2,2,3,3,4]
     * Output: 5, nums = [0,1,2,3,4]
     * Explanation: Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively. It doesn't matter what values are set beyond the returned length.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 0 <= nums.length <= 3 * 104
     * -104 <= nums[i] <= 104
     * nums is sorted in ascending order.
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int newArrayPointer = 0;
        for (int srcArrayPointer = 1; srcArrayPointer < nums.length; srcArrayPointer++) {
            if (nums[srcArrayPointer] != nums[srcArrayPointer - 1]) {
                newArrayPointer++;
                nums[newArrayPointer] = nums[srcArrayPointer];
            }
        }
        return newArrayPointer + 1;
    }

    /**
     * Roman to Integer
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     *
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
     *
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     *
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given a roman numeral, convert it to an integer.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "III"
     * Output: 3
     * Example 2:
     *
     * Input: s = "IV"
     * Output: 4
     * Example 3:
     *
     * Input: s = "IX"
     * Output: 9
     * Example 4:
     *
     * Input: s = "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     * Example 5:
     *
     * Input: s = "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 15
     * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
     * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
     */
    private static int romanToInt(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int res = 0;
        Map<Character, Integer> codeMap = createRomanToIntCodeMap();
        Integer previous = null;
        for (int i = 0; i < s.length(); i++) {
            Integer current = codeMap.get(s.charAt(i));
            if (previous != null && current > previous) {
                res = res - previous + (current - previous);
            } else {
                res += current;
            }
            previous = current;
        }
        return res;
    }

    private static Map<Character, Integer> createRomanToIntCodeMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }

    private static int romanToInt2(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int res = 0;
        Map<Character, Integer> codeMap = createRomanToIntCodeMap();
        for (int i = 0; i < s.length(); i++) {
            int current = codeMap.get(s.charAt(i));
            int next = i+1 < s.length() ? codeMap.get(s.charAt(i+1)) : -1;
            if (next != -1 && next > current) {
                res += (next - current);
                i++;
            } else {
                res += current;
            }
        }
        return res;
    }

    /**
     * Valid Parentheses
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     *
     *
     * Example 1:
     *
     * Input: s = "()"
     * Output: true
     * Example 2:
     *
     * Input: s = "()[]{}"
     * Output: true
     * Example 3:
     *
     * Input: s = "(]"
     * Output: false
     * Example 4:
     *
     * Input: s = "([)]"
     * Output: false
     * Example 5:
     *
     * Input: s = "{[]}"
     * Output: true
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 104
     * s consists of parentheses only '()[]{}'.
     */
    private static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            final char currentChar = s.charAt(i);
            if (stack.isEmpty()) {
                stack.add(currentChar);
            } else {
                if (map.containsKey(currentChar)) {
                    if (stack.peek().equals(map.get(currentChar))) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    stack.add(currentChar);
                }
            }
        }
        return stack.isEmpty();
    }
}
