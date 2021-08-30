package ru.list.surkovr.exercises.other;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TreeTest {

    /*
          1
         / \
        2   2
       / \ / \
      3  4 4  3
     */

    @Test
    public void isSymmetricTest() {
        Tree tree = new Tree();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        TreeNode leftLeft = new TreeNode(3);
        TreeNode leftRight = new TreeNode(4);
        TreeNode rightLeft = new TreeNode(4);
        TreeNode rightRight = new TreeNode(3);

        left.setLeft(leftLeft);
        left.setRight(leftRight);
        right.setLeft(rightLeft);
        right.setRight(rightRight);
        root.setLeft(left);
        root.setRight(right);

        tree.setRoot(root);

        boolean actual = tree.isSymmetric();
        Assertions.assertThat(actual).isTrue();
    }

    /*
          1
         / \
        2   2
       / \ / \
      3  5 3  5
     */

    @Test
    public void isSymmetricTest_NotSym() {
        Tree tree = new Tree();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        TreeNode leftLeft = new TreeNode(3);
        TreeNode leftRight = new TreeNode(5);
        TreeNode rightLeft = new TreeNode(3);
        TreeNode rightRight = new TreeNode(5);

        left.setLeft(leftLeft);
        left.setRight(leftRight);
        right.setLeft(rightLeft);
        right.setRight(rightRight);
        root.setLeft(left);
        root.setRight(right);

        tree.setRoot(root);

        boolean actual = tree.isSymmetric();
        Assertions.assertThat(actual).isFalse();
    }
}
