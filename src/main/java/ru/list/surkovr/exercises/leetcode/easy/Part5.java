package ru.list.surkovr.exercises.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Part5 {

    public static void main(String[] args) {
        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(8);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.left.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(2);
        System.out.println(isEvenOddTree(root));
    }

    public static boolean isEvenOddTree(TreeNode root) {
        if (root == null || root.val % 2 == 0) return false;
        Queue<TreeNode> queue = new LinkedList<>(List.of(root));
        List<List<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.peek();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                temp.add(queue.poll().val);
            }
            list.add(temp);
        }

        for (int i = 0; i < list.size(); i++) {
            List<Integer> level = list.get(i);
            if (isOdd(i)) {
                int last = Integer.MIN_VALUE;
                for (int num : level) {
                    if (isOdd(num) || num <= last) return false;
                    last = num;
                }
            } else {
                int last = Integer.MAX_VALUE;
                for (int num : level) {
                    if (!isOdd(num) || num >= last) return false;
                    last = num;
                }
            }
        }

        return true;
    }

    private static boolean isOdd(int level) {
        return level % 2 == 0;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
