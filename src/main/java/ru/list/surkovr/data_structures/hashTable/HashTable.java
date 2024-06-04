package ru.list.surkovr.data_structures.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTable {

    /**
     * 3146. Permutation Difference between Two Strings
     * Easy
     * Topics
     * Companies
     * Hint
     * You are given two strings s and t such that every character occurs at most once in s and t is a permutation of s.
     *
     * The permutation difference between s and t is defined as the sum of the absolute difference between the index of the occurrence of each character in s and the index of the occurrence of the same character in t.
     *
     * Return the permutation difference between s and t.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abc", t = "bac"
     *
     * Output: 2
     *
     * Explanation:
     *
     * For s = "abc" and t = "bac", the permutation difference of s and t is equal to the sum of:
     *
     * The absolute difference between the index of the occurrence of "a" in s and the index of the occurrence of "a" in t.
     * The absolute difference between the index of the occurrence of "b" in s and the index of the occurrence of "b" in t.
     * The absolute difference between the index of the occurrence of "c" in s and the index of the occurrence of "c" in t.
     * That is, the permutation difference between s and t is equal to |0 - 1| + |2 - 2| + |1 - 0| = 2.
     *
     * Example 2:
     *
     * Input: s = "abcde", t = "edbac"
     *
     * Output: 12
     *
     * Explanation: The permutation difference between s and t is equal to |0 - 3| + |1 - 2| + |2 - 4| + |3 - 1| + |4 - 0| = 12.
     *
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 26
     * Each character occurs at most once in s.
     * t is a permutation of s.
     * s consists only of lowercase English letters.
     */
    public static int findPermutationDifference(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) mapS.put(s.charAt(i), i);
        for (int i = 0; i < t.length(); i++) mapT.put(t.charAt(i), i);
        int res = 0;
        for (Map.Entry<Character, Integer> entry : mapS.entrySet()) {
            res += Math.abs(entry.getValue() - mapT.get(entry.getKey()));
        }
        return res;
    }

    public static int findPermutationDifference2(String s, String t) {
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) mapT.put(t.charAt(i), i);
        int res = 0;
        for (int i = 0; i < s.length(); i++) res += Math.abs(i - mapT.get(s.charAt(i)));
        return res;
    }

    public static int findPermutationDifference3(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) res += Math.abs(i - t.indexOf(s.charAt(i)));
        return res;
    }

    /**
     * 1282. Group the People Given the Group Size They Belong To
     * Medium
     * Topics
     * Companies
     * Hint
     * There are n people that are split into some unknown number of groups. Each person is labeled with a unique ID from 0 to n - 1.
     *
     * You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in. For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.
     *
     * Return a list of groups such that each person i is in a group of size groupSizes[i].
     *
     * Each person should appear in exactly one group, and every person must be in a group. If there are multiple answers, return any of them. It is guaranteed that there will be at least one valid solution for the given input.
     *
     *
     *
     * Example 1:
     *
     * Input: groupSizes = [3,3,3,3,3,1,3]
     * Output: [[5],[0,1,2],[3,4,6]]
     * Explanation:
     * The first group is [5]. The size is 1, and groupSizes[5] = 1.
     * The second group is [0,1,2]. The size is 3, and groupSizes[0] = groupSizes[1] = groupSizes[2] = 3.
     * The third group is [3,4,6]. The size is 3, and groupSizes[3] = groupSizes[4] = groupSizes[6] = 3.
     * Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
     * Example 2:
     *
     * Input: groupSizes = [2,1,3,3,3,2]
     * Output: [[1],[0,5],[2,3,4]]
     *
     *
     * Constraints:
     *
     * groupSizes.length == n
     * 1 <= n <= 500
     * 1 <= groupSizes[i] <= n
     */
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            if (!map.containsKey(groupSize)) {
                map.put(groupSize, new ArrayList<>());
            }
            List<Integer> list = map.get(groupSize);
            list.add(i);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer size = entry.getKey();
            List<Integer> persons = entry.getValue();
            if (persons.size() == size) res.add(persons);
            else {
                List<Integer> temp = new ArrayList<>();
                for (var person : persons) {
                    temp.add(person);
                    if (temp.size() == size) {
                        res.add(temp);
                        temp = new ArrayList<>();
                    }
                }
            }
        }

        return res;
    }
}
