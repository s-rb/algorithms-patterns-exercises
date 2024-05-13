package ru.list.surkovr.algorithms.dfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DepthFirstSearch {

    /**
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [1,null,2,3]
     * Output: [1,3,2]
     * Example 2:
     *
     * Input: root = []
     * Output: []
     * Example 3:
     *
     * Input: root = [1]
     * Output: [1]
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [0, 100].
     * -100 <= Node.val <= 100
     *
     *
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private static void dfs(TreeNode node, List<Integer> list) {
        if (node == null) return;
        if (node.left != null) dfs(node.left, list);
        list.add(node.val);
        if (node.right != null) dfs(node.right, list);
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

    /**
     * 802. Find Eventual Safe States
     * Medium
     * Topics
     * Companies
     * There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
     *
     * A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
     *
     * Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
     *
     *
     *
     * Example 1:
     *
     * Illustration of graph
     * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
     * Output: [2,4,5,6]
     * Explanation: The given graph is shown above.
     * Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
     * Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
     * Example 2:
     *
     * Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
     * Output: [4]
     * Explanation:
     * Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
     */
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (isSafe(i, graph, visited)) result.add(i);
        }
        result.sort(Comparator.naturalOrder());
        return result;
    }

    private static boolean isSafe(int i, int[][] graph, int[] visited) {
        int[] edges = graph[i];
        if (edges.length == 0) return true;
        if (visited[i] == -1) return false;
        if (visited[i] == 1) return true;

        visited[i] = -1;

        for (int edge : edges) {
            if (!isSafe(edge, graph, visited)) return false;
        }
        visited[i] = 1;
        return true;
    }

    /**
     * 2265. Count Nodes Equal to Average of Subtree
     * Medium
     * Topics
     * Companies
     * Hint
     * Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.
     *
     * Note:
     *
     * The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
     * A subtree of root is a tree consisting of root and all of its descendants.
     *
     *
     * Example 1:
     *
     *
     * Input: root = [4,8,5,0,1,null,6]
     * Output: 5
     * Explanation:
     * For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
     * For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
     * For the node with value 0: The average of its subtree is 0 / 1 = 0.
     * For the node with value 1: The average of its subtree is 1 / 1 = 1.
     * For the node with value 6: The average of its subtree is 6 / 1 = 6.
     * Example 2:
     *
     *
     * Input: root = [1]
     * Output: 1
     * Explanation: For the node with value 1: The average of its subtree is 1 / 1 = 1.
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [1, 1000].
     * 0 <= Node.val <= 1000
     */
    private static int countedAvgEqualNodes = 0;

    public static int averageOfSubtree(TreeNode root) {
        dfs(root);
        return countedAvgEqualNodes;
    }

    private static int[] dfs(TreeNode node) {
        int[] data = new int[]{1, node.val};
        if (node.left != null) {
            int[] temp = dfs(node.left);
            data[0] = temp[0] + data[0];
            data[1] = temp[1] + data[1];
        }
        if (node.right != null) {
            int[] temp = dfs(node.right);
            data[0] = temp[0] + data[0];
            data[1] = temp[1] + data[1];
        }
        if (node.val == data[1] / data[0]) countedAvgEqualNodes++;
        return data;
    }

    public static int averageOfSubtree2(TreeNode root) {
        int[] res = dfs2(root);
        return res[2];
    }

    private static int[] dfs2(TreeNode node) {
        int[] data = new int[]{1, node.val, 0};
        if (node.left != null) {
            int[] temp = dfs2(node.left);
            data[0] = temp[0] + data[0];
            data[1] = temp[1] + data[1];
            data[2] = temp[2] + data[2];
        }
        if (node.right != null) {
            int[] temp = dfs2(node.right);
            data[0] = temp[0] + data[0];
            data[1] = temp[1] + data[1];
            data[2] = temp[2] + data[2];
        }
        if (node.val == data[1] / data[0]) data[2] = data[2] + 1;
        return data;
    }
}
