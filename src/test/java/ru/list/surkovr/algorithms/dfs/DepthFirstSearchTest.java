package ru.list.surkovr.algorithms.dfs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.list.surkovr.algorithms.dfs.DepthFirstSearch.TreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstSearchTest {

    @Test
    void inorderTraversal() {
        TreeNode root = new TreeNode(1, null,
                new TreeNode(2, new TreeNode(3), null));

        Assertions.assertThat(DepthFirstSearch.inorderTraversal(root)).isEqualTo(List.of(1,3,2));
    }

    @Test
    void eventualSafeNodes() {
        Assertions.assertThat(DepthFirstSearch.eventualSafeNodes(
                new int[][] {{1,2},{2,3},{5},{0},{5},{},{}}))
                .isEqualTo(List.of(2,4,5,6));
    }

    @Test
    void averageOfSubtree() {
        TreeNode root = new TreeNode(4,
                new TreeNode(8, new TreeNode(0), new TreeNode(1)),
                new TreeNode(5, null, new TreeNode(6)));
        Assertions.assertThat(DepthFirstSearch.averageOfSubtree(root))
                .isEqualTo(5);
    }
    @Test
    void averageOfSubtree2() {
        TreeNode root = new TreeNode(4,
                new TreeNode(8, new TreeNode(0), new TreeNode(1)),
                new TreeNode(5, null, new TreeNode(6)));
        Assertions.assertThat(DepthFirstSearch.averageOfSubtree2(root))
                .isEqualTo(5);
    }
}