package ru.list.surkovr.data_structures.tree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void rangeSumBST() {
        Tree.TreeNode node = new Tree.TreeNode(10);
        Tree.TreeNode node5 = new Tree.TreeNode(5);
        Tree.TreeNode node3 = new Tree.TreeNode(3);
        Tree.TreeNode node7 = new Tree.TreeNode(7);
        Tree.TreeNode node1 = new Tree.TreeNode(1);
        Tree.TreeNode node6 = new Tree.TreeNode(6);
        Tree.TreeNode node15 = new Tree.TreeNode(15);
        Tree.TreeNode node13 = new Tree.TreeNode(13);
        Tree.TreeNode node18 = new Tree.TreeNode(18);
        node.left = node5;
        node5.left = node3;
        node5.right = node7;
        node3.left = node1;
        node7.left = node6;
        node.right = node15;
        node15.left = node13;
        node15.right = node18;

        Assertions.assertThat(Tree.rangeSumBST(node, 6, 10)).isEqualTo(23);
    }

    @Test
    void bstToGst() {
        Tree.TreeNode node = new Tree.TreeNode(4);
        Tree.TreeNode node1 = new Tree.TreeNode(1);
        Tree.TreeNode node0 = new Tree.TreeNode(0);
        Tree.TreeNode node2 = new Tree.TreeNode(2);
        Tree.TreeNode node3 = new Tree.TreeNode(3);
        Tree.TreeNode node6 = new Tree.TreeNode(6);
        Tree.TreeNode node5 = new Tree.TreeNode(5);
        Tree.TreeNode node7 = new Tree.TreeNode(7);
        Tree.TreeNode node8 = new Tree.TreeNode(8);
        node.left = node1;
        node1.left = node0;
        node1.right = node2;
        node2.right = node3;
        node.right = node6;
        node6.left = node5;
        node6.right = node7;
        node7.right = node8;

        Tree.TreeNode treeNode = Tree.bstToGst(node);
    }
}