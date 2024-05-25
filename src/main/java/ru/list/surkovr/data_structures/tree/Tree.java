package ru.list.surkovr.data_structures.tree;

public class Tree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 938. Range Sum of BST
     * Easy
     * Topics
     * Companies
     * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
     * Output: 32
     * Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
     * Example 2:
     * <p>
     * <p>
     * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
     * Output: 23
     * Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the tree is in the range [1, 2 * 104].
     * 1 <= Node.val <= 105
     * 1 <= low <= high <= 105
     * All Node.val are unique.
     */
    public static int rangeSumBST(TreeNode root, int low, int high) {
        int s = 0;
        if (root.val >= low && root.val <= high) s += root.val;
        if (root.left != null) {
            int s1 = rangeSumBST(root.left, low, high);
            s += s1;
        }
        if (root.right != null) {
            int s1 = rangeSumBST(root.right, low, high);
            s += s1;
        }
        return s;
    }

    /**
     * 1038. Binary Search Tree to Greater Sum Tree
     * Medium
     * Topics
     * Companies
     * Hint
     * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
     *
     * As a reminder, a binary search tree is a tree that satisfies these constraints:
     *
     * The left subtree of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     *
     *
     * Example 1:
     *
     *
     * Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
     * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
     * Example 2:
     *
     * Input: root = [0,null,1]
     * Output: [1,null,1]
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [1, 100].
     * 0 <= Node.val <= 100
     * All the values in the tree are unique.
     *
     *
     * Note: This question is the same as 538: https://leetcode.com/problems/convert-bst-to-greater-tree/
     *
     */
    static int sum = 0;
    public static TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;
        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
    }
}
