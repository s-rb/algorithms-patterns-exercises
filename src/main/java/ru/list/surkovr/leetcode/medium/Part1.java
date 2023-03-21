package ru.list.surkovr.leetcode.medium;

import org.assertj.core.api.Assertions;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Part1 {

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
}
