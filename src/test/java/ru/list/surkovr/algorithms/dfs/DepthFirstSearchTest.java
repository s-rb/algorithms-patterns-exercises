package ru.list.surkovr.algorithms.dfs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstSearchTest {

    @Test
    void inorderTraversal() {
        DepthFirstSearch.TreeNode root = new DepthFirstSearch.TreeNode(1, null,
                new DepthFirstSearch.TreeNode(2, new DepthFirstSearch.TreeNode(3), null));

        Assertions.assertThat(DepthFirstSearch.inorderTraversal(root)).isEqualTo(List.of(1,3,2));
    }

    @Test
    void eventualSafeNodes() {
        Assertions.assertThat(DepthFirstSearch.eventualSafeNodes(
                new int[][] {{1,2},{2,3},{5},{0},{5},{},{}}))
                .isEqualTo(List.of(2,4,5,6));
    }
}