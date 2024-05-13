package ru.list.surkovr.algorithms.bfs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstSearchTest {

    @Test
    void getTargetCopy() {
        BreadthFirstSearch.TreeNode original = new BreadthFirstSearch.TreeNode(7);
        original.left = new BreadthFirstSearch.TreeNode(4);
        original.right = new BreadthFirstSearch.TreeNode(3);
        original.right.left = new BreadthFirstSearch.TreeNode(6);
        original.right.right = new BreadthFirstSearch.TreeNode(19);

        BreadthFirstSearch.TreeNode copy = new BreadthFirstSearch.TreeNode(7);
        copy.left = new BreadthFirstSearch.TreeNode(4);
        copy.right = new BreadthFirstSearch.TreeNode(3);
        copy.right.left = new BreadthFirstSearch.TreeNode(6);
        copy.right.right = new BreadthFirstSearch.TreeNode(19);

        BreadthFirstSearch.TreeNode target = original.right;

        BreadthFirstSearch.TreeNode found = BreadthFirstSearch.getTargetCopy(original, copy, target);
        Assertions.assertThat(found == copy.right).isTrue();
    }

    @Test
    void getTargetCopyRecursive() {
        BreadthFirstSearch.TreeNode original = new BreadthFirstSearch.TreeNode(7);
        original.left = new BreadthFirstSearch.TreeNode(4);
        original.right = new BreadthFirstSearch.TreeNode(3);
        original.right.left = new BreadthFirstSearch.TreeNode(6);
        original.right.right = new BreadthFirstSearch.TreeNode(19);

        BreadthFirstSearch.TreeNode copy = new BreadthFirstSearch.TreeNode(7);
        copy.left = new BreadthFirstSearch.TreeNode(4);
        copy.right = new BreadthFirstSearch.TreeNode(3);
        copy.right.left = new BreadthFirstSearch.TreeNode(6);
        copy.right.right = new BreadthFirstSearch.TreeNode(19);

        BreadthFirstSearch.TreeNode target = original.right;

        BreadthFirstSearch.TreeNode found = BreadthFirstSearch.getTargetCopyRecursive(original, copy, target);
        Assertions.assertThat(found == copy.right).isTrue();
    }
}