package ru.list.surkovr.data_structures.stack;

import ru.list.surkovr.data_structures.tree.Tree;
import ru.list.surkovr.data_structures.tree.Tree.TreeNode;

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

    /**
     * 654. Maximum Binary Tree
     * Medium
     * Topics
     * Companies
     * You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:
     *
     * Create a root node whose value is the maximum value in nums.
     * Recursively build the left subtree on the subarray prefix to the left of the maximum value.
     * Recursively build the right subtree on the subarray suffix to the right of the maximum value.
     * Return the maximum binary tree built from nums.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: nums = [3,2,1,6,0,5]
     * Output: [6,3,5,null,2,0,null,null,1]
     * Explanation: The recursive calls are as follow:
     * - The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right suffix is [0,5].
     *     - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix is [2,1].
     *         - Empty array, so no child.
     *         - The largest value in [2,1] is 2. Left prefix is [] and right suffix is [1].
     *             - Empty array, so no child.
     *             - Only one element, so child is a node with value 1.
     *     - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is [].
     *         - Only one element, so child is a node with value 0.
     *         - Empty array, so no child.
     * Example 2:
     *
     *
     * Input: nums = [3,2,1]
     * Output: [3,null,2,null,1]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 1000
     * 0 <= nums[i] <= 1000
     * All integers in nums are unique.
     */
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }

    public static TreeNode construct(int[] nums, int from, int to) {
        if (nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);

        int maxIndex = from;
        int max = nums[from];
        for (int i = from+1; i <= to; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                max = nums[i];
            }
        }
        var treeNode = new TreeNode(max);
        if (from < maxIndex) {
            treeNode.left = construct(nums, from, maxIndex-1);
        }
        if (to > maxIndex) {
            treeNode.right = construct(nums, maxIndex+1, to);
        }
        return treeNode;
    }
}
