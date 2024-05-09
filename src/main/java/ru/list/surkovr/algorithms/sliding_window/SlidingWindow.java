package ru.list.surkovr.algorithms.sliding_window;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SlidingWindow {

    /**
     * A string is good if there are no repeated characters.
     *
     * Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.
     *
     * Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
     *
     * A substring is a contiguous sequence of characters in a string.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "xyzzaz"
     * Output: 1
     * Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
     * The only good substring of length 3 is "xyz".
     * Example 2:
     *
     * Input: s = "aababcabc"
     * Output: 4
     * Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
     * The good substrings are "abc", "bca", "cab", and "abc".
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 100
     * s​​​​​​ consists of lowercase English letters.
     */
    public static int countGoodSubstrings(String s) {
        int count = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length() - 2; i++) {
            set.add(s.charAt(i));
            set.add(s.charAt(i+1));
            set.add(s.charAt(i+2));
            if (set.size() == 3) count++;
            set.clear();
        }
        return count;
    }

    public static int countGoodSubstrings2(String s) {
        int count = 0;
        Set<Character> set = new LinkedHashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while (!set.add(ch)) {
                set.remove(set.iterator().next());
            }
            if (set.size() == 3) {
                count++;
                set.remove(set.iterator().next());
            }
        }
        return count;
    }

    public static int countGoodSubstrings3(String s) {
        int count = 0;
        Set<Character> set = new LinkedHashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (set.size() == 3) {
                count++;
                set.remove(set.iterator().next());
            }

            char ch = s.charAt(i);
            while (!set.add(ch)) {
                set.remove(set.iterator().next());
            }
        }
        if (set.size() == 3) count++;
        return count;
    }
}


