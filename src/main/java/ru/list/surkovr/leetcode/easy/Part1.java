package ru.list.surkovr.leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;

public class Part1 {

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
    public static int[] getTwoSum(int[] nums, int target) {
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
     * <p>
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
     * <p>
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     * <p>
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given a roman numeral, convert it to an integer.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "III"
     * Output: 3
     * Example 2:
     * <p>
     * Input: s = "IV"
     * Output: 4
     * Example 3:
     * <p>
     * Input: s = "IX"
     * Output: 9
     * Example 4:
     * <p>
     * Input: s = "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     * Example 5:
     * <p>
     * Input: s = "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 15
     * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
     * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
     */
    public static int romanToInt(String s) {
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

    public static Map<Character, Integer> createRomanToIntCodeMap() {
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

    public static int romanToInt2(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int res = 0;
        Map<Character, Integer> codeMap = createRomanToIntCodeMap();
        for (int i = 0; i < s.length(); i++) {
            int current = codeMap.get(s.charAt(i));
            int next = i + 1 < s.length() ? codeMap.get(s.charAt(i + 1)) : -1;
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
     * <p>
     * An input string is valid if:
     * <p>
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "()"
     * Output: true
     * Example 2:
     * <p>
     * Input: s = "()[]{}"
     * Output: true
     * Example 3:
     * <p>
     * Input: s = "(]"
     * Output: false
     * Example 4:
     * <p>
     * Input: s = "([)]"
     * Output: false
     * Example 5:
     * <p>
     * Input: s = "{[]}"
     * Output: true
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 104
     * s consists of parentheses only '()[]{}'.
     */
    public static boolean isValid(String s) {
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

    /**
     * You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()" and/or "(al)" in some order. The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al". The interpreted strings are then concatenated in the original order.
     * <p>
     * Given the string command, return the Goal Parser's interpretation of command.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: command = "G()(al)"
     * Output: "Goal"
     * Explanation: The Goal Parser interprets the command as follows:
     * G -> G
     * () -> o
     * (al) -> al
     * The final concatenated result is "Goal".
     * Example 2:
     * <p>
     * Input: command = "G()()()()(al)"
     * Output: "Gooooal"
     * Example 3:
     * <p>
     * Input: command = "(al)G(al)()()G"
     * Output: "alGalooG"
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= command.length <= 100
     * command consists of "G", "()", and/or "(al)" in some order.
     */
    public static String interpret(String command) {
        return command.replaceAll("\\(\\)", "o").replaceAll("\\(al\\)", "al");
    }

    public static String interpret2(String command) {
        char[] res = new char[command.length()];
        int j = 0;
        for (int i = 0; i < command.length(); i++, j++) {
            if (command.charAt(i) == 'G') {
                res[j] = 'G';
                continue;
            } else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                res[j] = 'o';
                i++;
                continue;
            } else if (command.charAt(i) == '(' && command.charAt(i + 1) == 'a') {
                res[j] = 'a';
                res[j + 1] = 'l';
                j++;
                i = i + 3;
                continue;
            }
        }
        return String.copyValueOf(res, 0, j);
    }

    /**
     * Remove All Adjacent Duplicates In String
     * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
     * <p>
     * We repeatedly make duplicate removals on S until we no longer can.
     * <p>
     * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: "abbaca"
     * Output: "ca"
     * Explanation:
     * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
     * <p>
     * <p>
     * Note:
     * <p>
     * 1 <= S.length <= 20000
     * S consists only of English lowercase letters.
     */
    // Too slow. Recursive
    public static String removeDuplicates(String s) {
        int length = s.length();
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                if (i == 0) {
                    return removeDuplicates(s.substring(i + 2));
                } else {
                    return removeDuplicates(s.substring(0, i) + s.substring(i + 2));
                }
            }
        }
        return s;
    }

    public static String removeDuplicates2(String s) {
        int length = s.length();
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                if (i == 0) {
                    s = s.substring(i + 2);
                } else {
                    s = s.substring(0, i) + s.substring(i + 2);
                }
                i = -1;
                length = s.length();
            }
        }
        return s;
    }

    public static String removeDuplicates3(String s) {
        char[] res = new char[s.length()];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j > 0 && s.charAt(i) == res[j - 1]) {
                j--;
            } else {
                res[j] = s.charAt(i);
                j++;
            }
        }
        return String.copyValueOf(res, 0, j);
    }

    /**
     * Richest Customer Wealth
     * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.
     * <p>
     * A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: accounts = [[1,2,3],[3,2,1]]
     * Output: 6
     * Explanation:
     * 1st customer has wealth = 1 + 2 + 3 = 6
     * 2nd customer has wealth = 3 + 2 + 1 = 6
     * Both customers are considered the richest with a wealth of 6 each, so return 6.
     * Example 2:
     * <p>
     * Input: accounts = [[1,5],[7,3],[3,5]]
     * Output: 10
     * Explanation:
     * 1st customer has wealth = 6
     * 2nd customer has wealth = 10
     * 3rd customer has wealth = 8
     * The 2nd customer is the richest with a wealth of 10.
     * Example 3:
     * <p>
     * Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
     * Output: 17
     * <p>
     * <p>
     * Constraints:
     * <p>
     * m == accounts.length
     * n == accounts[i].length
     * 1 <= m, n <= 50
     * 1 <= accounts[i][j] <= 100
     */
    public static int maximumWealth(int[][] accounts) {
        int richestMoney = 0;
        for (int[] customerAccounts : accounts) {
            int currentMoney = 0;
            for (int curBankMoney : customerAccounts) {
                currentMoney += curBankMoney;
            }
            if (currentMoney > richestMoney) {
                richestMoney = currentMoney;
            }
        }
        return richestMoney;
    }

    /**
     * Longest Continuous Increasing Subsequence
     * Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). The subsequence must be strictly increasing.
     * <p>
     * A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,3,5,4,7]
     * Output: 3
     * Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
     * Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element
     * 4.
     * Example 2:
     * <p>
     * Input: nums = [2,2,2,2,2]
     * Output: 1
     * Explanation: The longest continuous increasing subsequence is [2] with length 1. Note that it must be strictly
     * increasing.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 0 <= nums.length <= 10^4
     * -10^9 <= nums[i] <= 10^9
     */
    public static int findLengthOfLCIS(int[] nums) {
        int res = 0;
        if (nums.length == 0) {
            return res;
        }
        res = 1;
        int cur = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                cur++;
            } else {
                res = Math.max(cur, res);
                cur = 1;
            }
        }
        return Math.max(cur, res);
    }

    /**
     * Reverse Words in a String III
     * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
     * <p>
     * Example 1:
     * Input: "Let's take LeetCode contest"
     * Output: "s'teL ekat edoCteeL tsetnoc"
     * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
     */
    public static String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        char[] res = new char[s.length()];
        int resPointer = 0;
        for (int i = 0; i < s.length(); i++) {
            final char curChar = s.charAt(i);
            if (curChar == ' ') {
                while (!stack.isEmpty()) {
                    res[resPointer] = stack.pop();
                    resPointer++;
                }
                res[resPointer] = curChar;
                resPointer++;
            } else if (i == s.length() - 1) {
                stack.add(curChar);
                while (!stack.isEmpty()) {
                    res[resPointer] = stack.pop();
                    resPointer++;
                }
            } else {
                stack.add(curChar);
            }
        }
        return String.copyValueOf(res);
    }

    public static String reverseWords2(String s) {
        return Arrays.stream(s.split(" "))
                .map(str -> new StringBuilder(str).reverse().toString())
                .collect(Collectors.joining(" "));
    }

    public static String reverseWords3(String s) {
        int index = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;

        for (int i = 0; i <= len; i++) {
            if (i == len || chars[i] == ' ') {
                reverse(chars, index, i - 1);
                index = i + 1;
            }
        }

        return new String(chars);
    }

    public static void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }

    // TODO

    /**
     * Sum of Left Leaves
     * Find the sum of all left leaves in a given binary tree.
     * <p>
     * Example:
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (Objects.isNull(root)) {
            return sum;
        }
        return getSum(root, false, sum);
    }

    public static Integer getSum(TreeNode node, boolean isLeft, Integer sum) {
        if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
            if (isLeft) {
                return sum += node.val;
            }
        }
        if (Objects.nonNull(node.left)) {
            sum = getSum(node.left, true, sum);
        }
        if (Objects.nonNull(node.right)) {
            sum = getSum(node.right, false, sum);
        }
        return sum;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int sumOfLeftLeaves2(TreeNode root) {
        return calcSum(root);
    }

    public static int calcSum(TreeNode node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        int sum = 0;
        if (Objects.nonNull(node.left) && Objects.isNull(node.left.left) && Objects.isNull(node.left.right)) {
            sum += node.left.val;
        }
        sum += calcSum(node.left) + calcSum(node.right);
        return sum;
    }

    /*
    Reverse integer
    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value
    to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
    */
    public static int reverseInt(int x) {
        final String s = Integer.toUnsignedString(x);
        String reversed = "";
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            reversed = s.charAt(i) + reversed;
        }
        try {
            return Integer.parseUnsignedInt(reversed);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 2869. Minimum Operations to Collect Elements
     * Solved
     * Easy
     * Topics
     * Companies
     * Hint
     * You are given an array nums of positive integers and an integer k.
     *
     * In one operation, you can remove the last element of the array and add it to your collection.
     *
     * Return the minimum number of operations needed to collect elements 1, 2, ..., k.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [3,1,5,4,2], k = 2
     * Output: 4
     * Explanation: After 4 operations, we collect elements 2, 4, 5, and 1, in this order. Our collection contains elements 1 and 2. Hence, the answer is 4.
     * Example 2:
     *
     * Input: nums = [3,1,5,4,2], k = 5
     * Output: 5
     * Explanation: After 5 operations, we collect elements 2, 4, 5, 1, and 3, in this order. Our collection contains elements 1 through 5. Hence, the answer is 5.
     * Example 3:
     *
     * Input: nums = [3,2,5,3,1], k = 3
     * Output: 4
     * Explanation: After 4 operations, we collect elements 1, 3, 5, and 2, in this order. Our collection contains elements 1 through 3. Hence, the answer is 4.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 50
     * 1 <= nums[i] <= nums.length
     * 1 <= k <= nums.length
     * The input is generated such that you can collect elements 1, 2, ..., k.
     */
    public static int minOperations(List<Integer> nums, int k) {
        Set<Integer> processed = new HashSet<>();

        int step = 1;
        for (int i = nums.size() - step; i >= 0; i--) {
            int element = nums.get(i);
            if (element <= k && !processed.contains(element)) {
                processed.add(element);
                if (processed.size() == k) break;
            }
            step++;
        }
        return step;
    }
}
