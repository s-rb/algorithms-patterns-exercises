package ru.list.surkovr.exercises.other;

import static java.util.Objects.isNull;

public class Tree {

    private TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    public Tree() {
    }

    public boolean isSymmetric() {
        if (isNull(root)) {
            return false;
        }
        return isSymmetric(root.getLeft(), root.getRight());
    }

    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (isNull(node1) && isNull(node2)) {
            return true;
        }
        if ((isNull(node1) || isNull(node2))) {
            return false;
        }
        return node1.getValue() == node2.getValue()
                && isSymmetric(node1.getLeft(), node2.getRight())
                && isSymmetric(node1.getRight(), node2.getLeft());
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}
