package ru.list.surkovr.data_structures;

import org.junit.jupiter.api.Test;
import ru.list.surkovr.data_structures.binary_tree.BinaryTree;
import ru.list.surkovr.data_structures.binary_tree.Node;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeTest {

    @Test
    public void addNodeTest() {
        BinaryTree tree = new BinaryTree();
        assertThat(tree.getRoot()).isNull();
        String data = "3";
        String dataLeft = "2";
        String dataRight = "5";
        tree.addNode(data);
        tree.addNode(dataLeft);
        tree.addNode(dataRight);
        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getData()).isEqualTo(data);
        assertThat(tree.getRoot().getLeft()).isNotNull();
        assertThat(tree.getRoot().getLeft().getData()).isNotNull().isEqualTo(dataLeft);
        assertThat(tree.getRoot().getRight()).isNotNull();
        assertThat(tree.getRoot().getRight().getData()).isNotNull().isEqualTo(dataRight);
    }

    @Test
    public void searchNodesTest() {
        BinaryTree tree = new BinaryTree();
        assertThat(tree.getRoot()).isNull();
        String data = "3";
        String dataLeft = "2";
        String dataRight = "5";
        tree.addNode(data);
        tree.addNode(dataLeft);
        tree.addNode(dataRight);
        assertThat(tree.getRoot()).isNotNull();
        assertThat(tree.getRoot().getData()).isEqualTo(data);
        assertThat(tree.getRoot().getLeft()).isNotNull();
        assertThat(tree.getRoot().getLeft().getData()).isNotNull().isEqualTo(dataLeft);
        assertThat(tree.getRoot().getRight()).isNotNull();
        assertThat(tree.getRoot().getRight().getData()).isNotNull().isEqualTo(dataRight);
        String dataToFind = "3";
        List<Node> nodes = tree.searchNodes(dataToFind);
        assertThat(nodes).isNotNull().hasSize(1);
        assertThat(nodes.get(0)).isNotNull();
        assertThat(nodes.get(0).getData()).isEqualTo(dataToFind);
    }
}
