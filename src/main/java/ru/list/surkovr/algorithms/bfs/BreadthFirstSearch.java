package ru.list.surkovr.algorithms.bfs;

import ru.list.surkovr.exercises.other.Tree;

import java.util.LinkedList;

public class BreadthFirstSearch {

    /**
     * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
     * Easy
     * Topics
     * Companies
     * Given two binary trees original and cloned and given a reference to a node target in the original tree.
     *
     * The cloned tree is a copy of the original tree.
     *
     * Return a reference to the same node in the cloned tree.
     *
     * Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: tree = [7,4,3,null,null,6,19], target = 3
     * Output: 3
     * Explanation: In all examples the original and cloned trees are shown. The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.
     * Example 2:
     *
     *
     * Input: tree = [7], target =  7
     * Output: 7
     * Example 3:
     *
     *
     * Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
     * Output: 4
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [1, 104].
     * The values of the nodes of the tree are unique.
     * target node is a node from the original tree and is not null.
     *
     *
     * Follow up: Could you solve the problem if repeated values on the tree are allowed?
     */
    public static TreeNode getTargetCopy(final TreeNode original,
                                         final TreeNode cloned,
                                         final TreeNode target) {
        if (original == target) return cloned;
        LinkedList<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{original, cloned});
        while (!queue.isEmpty()) {
            TreeNode[] node = queue.poll();
            if (node[0] == target) return node[1];
            if (node[0].left != null) queue.add(new TreeNode[]{node[0].left, node[1].left});
            if (node[0].right != null) queue.add(new TreeNode[]{node[0].right, node[1].right});
        }
        return null;
    }

    public static TreeNode getTargetCopyRecursive(final TreeNode original,
                                                  final TreeNode cloned,
                                                  final TreeNode target) {
        if (original == target) return cloned;
        if (original.left != null) {
            TreeNode found = getTargetCopy(original.left, cloned.left, target);
            if (found != null) return found;
        }
        if (original.right != null) {
            TreeNode found = getTargetCopy(original.right, cloned.right, target);
            if (found != null) return found;
        }
        return null;
    }

    /**
     * 1315. Sum of Nodes with Even-Valued Grandparent
     * Medium
     * Topics
     * Companies
     * Hint
     * Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes with an even-valued grandparent, return 0.
     *
     * A grandparent of a node is the parent of its parent if it exists.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
     * Output: 18
     * Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
     * Example 2:
     *
     *
     * Input: root = [1]
     * Output: 0
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [1, 104].
     * 1 <= Node.val <= 100
     */
    private static int SUM = 0;

    public static int sumEvenGrandparent(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        TreeNode left = root.left;
        if (left != null) {
            bfs(left.left, left, root);
            bfs(left.right, left, root);
        }
        TreeNode right = root.right;
        if (right != null) {
            bfs(right.left, right, root);
            bfs(right.right, right, root);
        }
        return SUM;
    }

    private static void bfs(TreeNode current, TreeNode parent, TreeNode grandparent) {
        if (current == null) return;
        if (grandparent.val % 2 == 0) SUM += current.val;
        bfs(current.left, current, parent);
        bfs(current.right, current, parent);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
