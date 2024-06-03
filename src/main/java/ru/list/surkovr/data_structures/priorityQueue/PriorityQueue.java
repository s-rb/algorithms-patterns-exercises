package ru.list.surkovr.data_structures.priorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class PriorityQueue {

    /**
     * 2974. Minimum Number Game
     * Easy
     * Topics
     * Companies
     * Hint
     * You are given a 0-indexed integer array nums of even length and there is also an empty array arr. Alice and Bob decided to play a game where in every round Alice and Bob will do one move. The rules of the game are as follows:
     *
     * Every round, first Alice will remove the minimum element from nums, and then Bob does the same.
     * Now, first Bob will append the removed element in the array arr, and then Alice does the same.
     * The game continues until nums becomes empty.
     * Return the resulting array arr.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [5,4,2,3]
     * Output: [3,2,5,4]
     * Explanation: In round one, first Alice removes 2 and then Bob removes 3. Then in arr firstly Bob appends 3 and then Alice appends 2. So arr = [3,2].
     * At the begining of round two, nums = [5,4]. Now, first Alice removes 4 and then Bob removes 5. Then both append in arr which becomes [3,2,5,4].
     * Example 2:
     *
     * Input: nums = [2,5]
     * Output: [5,2]
     * Explanation: In round one, first Alice removes 2 and then Bob removes 5. Then in arr firstly Bob appends and then Alice appends. So arr = [5,2].
     *
     *
     * Constraints:
     *
     * 2 <= nums.length <= 100
     * 1 <= nums[i] <= 100
     * nums.length % 2 == 0
     */
    public static int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i=i+2) {
            int temp = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = temp;
        }
        return nums;
    }

    public static int[] numberGame2(int[] nums) {
        java.util.PriorityQueue<Integer> queue = new java.util.PriorityQueue<>();
        for (int num : nums) queue.add(num);
        for (int i = 0; i < nums.length; i++) nums[i % 2 != 0 ? (i - 1) : (i + 1)] = queue.poll();
        return nums;
    }

    /**
     * 451. Sort Characters By Frequency
     * Medium
     * Topics
     * Companies
     * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
     *
     * Return the sorted string. If there are multiple answers, return any of them.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "tree"
     * Output: "eert"
     * Explanation: 'e' appears twice while 'r' and 't' both appear once.
     * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
     * Example 2:
     *
     * Input: s = "cccaaa"
     * Output: "aaaccc"
     * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
     * Note that "cacaca" is incorrect, as the same characters must be together.
     * Example 3:
     *
     * Input: s = "Aabb"
     * Output: "bbAa"
     * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
     * Note that 'A' and 'a' are treated as two different characters.
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 5 * 105
     * s consists of uppercase and lowercase English letters and digits.
     */
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
        java.util.PriorityQueue<Map.Entry<Character, Integer>> queue = new java.util.PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        queue.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            var e = queue.poll();
            sb.append(String.valueOf(e.getKey()).repeat(e.getValue()));
        }
        return sb.toString();
    }
}
