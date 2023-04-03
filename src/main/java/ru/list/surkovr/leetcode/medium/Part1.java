package ru.list.surkovr.leetcode.medium;

import org.assertj.core.api.Assertions;
import ru.list.surkovr.algorithms.Backtracking;

import java.util.*;

public class Part1 {

    /**
     * 1079. Letter Tile Possibilities
     * Medium
     * 2.2K
     * 60
     * Companies
     * You have n  tiles, where each tile has one letter tiles[i] printed on it.
     *
     * Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
     *
     *
     *
     * Example 1:
     *
     * Input: tiles = "AAB"
     * Output: 8
     * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
     * Example 2:
     *
     * Input: tiles = "AAABBC"
     * Output: 188
     * Example 3:
     *
     * Input: tiles = "V"
     * Output: 1
     *
     *
     * Constraints:
     *
     * 1 <= tiles.length <= 7
     * tiles consists of uppercase English letters.
     */
    private static Set<String> set = new HashSet<>(); // to avoid duplicates

    public static int numTilePossibilities(String tiles) {
        if (tiles == null || tiles.isBlank()) return -1;
        if (tiles.length() == 1) return 1;
        boolean[] visited = new boolean[tiles.length()];
        backtrack(tiles, visited, new StringBuilder());
        return set.size();
    }

    private static void backtrack(String src, boolean[] visited, StringBuilder sb) {
        if (sb.length() > 0) {
            final String str = sb.toString();
            if (set.contains(str)) {
                return;
            } else {
                set.add(str);
            }
        }

        for (int i = 0; i < src.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            backtrack(src, visited, sb.append(src.charAt(i)));
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * Design the CombinationIterator class:
     *
     * CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
     * next() Returns the next combination of length combinationLength in lexicographical order.
     * hasNext() Returns true if and only if there exists a next combination.
     *
     * Example 1:
     *
     * Input
     * ["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
     * [["abc", 2], [], [], [], [], [], []]
     * Output
     * [null, "ab", true, "ac", true, "bc", false]
     *
     * Explanation
     * CombinationIterator itr = new CombinationIterator("abc", 2);
     * itr.next();    // return "ab"
     * itr.hasNext(); // return True
     * itr.next();    // return "ac"
     * itr.hasNext(); // return True
     * itr.next();    // return "bc"
     * itr.hasNext(); // return False
     *
     * Constraints:
     *
     * 1 <= combinationLength <= characters.length <= 15
     * All the characters of characters are unique.
     * At most 104 calls will be made to next and hasNext.
     * It is guaranteed that all calls of the function next are valid.
     */
    public static class CombinationIterator {
        // Generative approach
        private final Queue<String> queue; // We'll store here generated sequences

        public CombinationIterator(String text, int len) {
            queue = new PriorityQueue<>();
            if (len != 0) generate(text, len, 0, new StringBuilder());
        }

        public String next() {
            return queue.poll();
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }

        private void generate(String text, int len, int start, StringBuilder sb) {
            if (len == 0) {
                queue.add(sb.toString());
                return;
            }
            for (int i = start; i <= text.length() - len; i++) {
                sb.append(text.charAt(i)); // first char
                generate(text, len-1, i+1, sb); // find and append other chars recursive
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static class CombinationIterator2 {
        // Generative by bitmask approach
        private final Queue<String> queue; // We'll store here generated sequences

        public CombinationIterator2(String text, int len) {
            queue = new PriorityQueue<>(); // Source sequence is sorted, so we can use list instead of PriorityQueue
            if (len != 0) generate(text, len);
        }

        public String next() {
            return queue.poll();
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }

        private void generate(String text, int len) {
            int textLength = text.length();
            for (int mask = 0; mask < 1 << textLength; mask++) {
                if (Integer.bitCount(mask) != len) continue; // we need count bits to be equal len
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < textLength; i++) {
                    if (Integer.bitCount(mask & 1 << i) > 0) {
                        sb.append(text.charAt(i));
                    }
                }
                if (sb.length() > 0) queue.add(sb.toString());
            }
        }
    }

    private static int count = 0;

    public static int numTilePossibilities2(String tiles) {
        if (tiles == null || tiles.isEmpty()) return 0;
        if (tiles.length() == 1) return 1;
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        boolean[] visits = new boolean[tiles.length()];
        backtrack(chars, visits);
        return count;
    }

    private static void backtrack(char[] chars, boolean[] visits) {
        for (int i = 0; i < chars.length; i++) {
            if (visits[i]) continue;
            count++;
            visits[i] = true;
            backtrack(chars, visits);
            visits[i] = false;
            while (i != chars.length - 1 && chars[i+1] == chars[i]) i++;
        }
    }

    /**
     * 46. Permutations
     * Medium
     * 15.1K
     * 257
     * Companies
     * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3]
     * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * Example 2:
     *
     * Input: nums = [0,1]
     * Output: [[0,1],[1,0]]
     * Example 3:
     *
     * Input: nums = [1]
     * Output: [[1]]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * All the integers of nums are unique.
     */
    public static List<List<Integer>> permute(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        Backtracking.backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    /**
     * 784. Letter Case Permutation
     * Medium
     * 4.2K
     * 151
     * Companies
     * Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
     *
     * Return a list of all possible strings we could create. Return the output in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "a1b2"
     * Output: ["a1b2","a1B2","A1b2","A1B2"]
     * Example 2:
     *
     * Input: s = "3z4"
     * Output: ["3z4","3Z4"]
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 12
     * s consists of lowercase English letters, uppercase English letters, and digits.
     */
    public static List<String> letterCasePermutation(String s) {
        Set<String> res = new HashSet<>();
        backtrack(s.toCharArray(), new StringBuilder(), res);
        return new ArrayList<>(res);
    }

    private static void backtrack(char[] src, StringBuilder sb, Set<String> res) {
        if (sb.length() == src.length) {
            res.add(sb.toString());
            return;
        }

        int idx = sb.length();
        sb.append(Character.toLowerCase(src[idx]));
        backtrack(src, sb, res);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(Character.toUpperCase(src[idx]));
        backtrack(src, sb, res);
        sb.deleteCharAt(sb.length() - 1);
    }

    /**
     *
     */
    public static List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] isPalindromeArr = new boolean[len+1][len+1];
        String[][] subs = new String[len+1][len+1];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                subs[i][j] = s.substring(i, j);
                isPalindromeArr[i][j] = isPalindrome(subs[i][j]);
            }
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(0, len, isPalindromeArr, subs, res, new ArrayList<>());
        return res;
    }

    private static void backtrack(int index, int len, boolean[][] isPalin, String[][] subs, List<List<String>> res, List<String> list) {
        if (index == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= len; i++) {
            if (!isPalin[index][i]) continue;
            list.add(subs[index][i]);
            backtrack(i, len, isPalin, subs, res, list);
            list.remove(list.size() - 1);
        }
    }

    private static boolean isPalindrome(String s) {
        if (s.length() < 2) return true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }

    /**
     * 2044. Count Number of Maximum Bitwise-OR Subsets
     * Medium
     * 480
     * 15
     * Companies
     * Given an integer array nums, find the maximum possible bitwise OR of a subset of nums and return the number of different non-empty subsets with the maximum bitwise OR.
     *
     * An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b. Two subsets are considered different if the indices of the elements chosen are different.
     *
     * The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [3,1]
     * Output: 2
     * Explanation: The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3:
     * - [3]
     * - [3,1]
     * Example 2:
     *
     * Input: nums = [2,2,2]
     * Output: 7
     * Explanation: All non-empty subsets of [2,2,2] have a bitwise OR of 2. There are 23 - 1 = 7 total subsets.
     * Example 3:
     *
     * Input: nums = [3,2,1,5]
     * Output: 6
     * Explanation: The maximum possible bitwise OR of a subset is 7. There are 6 subsets with a bitwise OR of 7:
     * - [3,5]
     * - [3,1,5]
     * - [3,2,5]
     * - [3,2,1,5]
     * - [2,5]
     * - [2,1,5]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 16
     * 1 <= nums[i] <= 105
     */
    public static int countMaxOrSubsets(int[] nums) {
        SortedMap<Integer, List<List<Integer>>> map = new TreeMap<>();
        backtrack(0, nums, nums.length, map, new ArrayList<>());
        return map.get(map.lastKey()).size();
    }

    private static void backtrack(int idx, int[] nums, int len,
                           SortedMap<Integer, List<List<Integer>>> map,
                           List<Integer> list
    )
    {
        if (list.size() == 1) {
            var temp = map.getOrDefault(list.get(0), new ArrayList<>());
            temp.add(new ArrayList(list));
            map.put(list.get(0), temp);
        } else if (list.size() > 1) {
            var num = list.stream().reduce((o1, o2) -> o1 | o2).get();
            var temp = map.getOrDefault(num, new ArrayList<>());
            temp.add(new ArrayList(list));
            map.put(num, temp);
        }

        for (int i = idx; i < len; i++) {
            list.add(nums[i]);
            backtrack(i+1, nums, len, map, list);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 1291. Sequential Digits
     * Medium
     * 1.9K
     * 107
     * Companies
     * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
     *
     * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
     *
     *
     *
     * Example 1:
     *
     * Input: low = 100, high = 300
     * Output: [123,234]
     * Example 2:
     *
     * Input: low = 1000, high = 13000
     * Output: [1234,2345,3456,4567,5678,6789,12345]
     *
     *
     * Constraints:
     *
     * 10 <= low <= high <= 10^9
     */
    public static List<Integer> sequentialDigits(int low, int high) {
        // 12, 23, 34, 45, 56, 67, 78, 89 - t=8, incr=11
        // 123, 234, 345, 456, 567, 678, 789 - t=7, incr=111
        int start = 1;
        int times = 8;
        int current = 1;
        int incr = 11;

        List<Integer> result = new ArrayList<>();
        while (current <= high) {
            for (int i = 0; i < times; i++) {
                current = current + incr;
                if (current >= low && current <= high) result.add(current);
            }

            incr = 10 * incr + 1; // 11, 111, 1111...
            start = start * 10 + 10 - times; // 1, 12, 123..
            times--; // 8, 7, 6
            current = start;
        }
        return result;
    }

    /**
     *
     */
    public static List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum < 2L || finalSum % 2L != 0L) return res;
        long i = 2L;
        while (finalSum != 0L) {
            if (i > finalSum) {
                long last = res.remove(res.size()-1);
                finalSum += last;
                i = finalSum;
            }
            res.add(i);
            finalSum -= i;
            i += 2L;
        }
        return res;
    }

    static Integer res = 0;

    public static int countArrangement(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        boolean[] visited = new boolean[n];
        backtrack(n, visited, new ArrayList<>());
        return res;
    }

    private static void backtrack(int num, boolean[] visited, List<Integer> list) {
        if (list.size() == num) {
            res++;
            return;
        }

        for (int i = 1; i <= num; i++) {
            if (visited[i-1]) continue;
            if (i % (list.size()+1) != 0 && (list.size()+1) % i != 0) return;
            visited[i-1] = true;
            list.add(i);
            backtrack(num, visited, list);
            visited[i-1] = false;
            list.remove(list.size()-1);
        }
    }
}
