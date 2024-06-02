package ru.list.surkovr.data_structures.stack;

public class Stack {

    /**
     * 1614. Maximum Nesting Depth of the Parentheses
     * Easy
     * Topics
     * Companies
     * Hint
     * Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "(1+(2*3)+((8)/4))+1"
     *
     * Output: 3
     *
     * Explanation:
     *
     * Digit 8 is inside of 3 nested parentheses in the string.
     *
     * Example 2:
     *
     * Input: s = "(1)+((2))+(((3)))"
     *
     * Output: 3
     *
     * Explanation:
     *
     * Digit 3 is inside of 3 nested parentheses in the string.
     *
     * Example 3:
     *
     * Input: s = "()(())((()()))"
     *
     * Output: 3
     *
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 100
     * s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
     * It is guaranteed that parentheses expression s is a VPS.
     */
    public static int maxDepth(String s) {
        java.util.Stack<Integer> theStack = new java.util.Stack<>();
        int openC = '(';
        int closeC = ')';
        int maxDepth = 0;
        int depth = 0;
        for (Character c : s.toCharArray()) {
            if (c == openC) {
                theStack.add(openC);
                depth++;
            } else if (c == closeC) {
                theStack.pop();
                depth--;
            }
            maxDepth = Math.max(depth, maxDepth);
        }
        return maxDepth;
    }
}
