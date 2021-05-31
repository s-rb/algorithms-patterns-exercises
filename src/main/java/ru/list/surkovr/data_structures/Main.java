package ru.list.surkovr.data_structures;

import ru.list.surkovr.data_structures.binary_tree.BinaryTree;
import ru.list.surkovr.data_structures.binary_tree.Node;
import ru.list.surkovr.data_structures.double_linked_list.DoubleLinkedList;
import ru.list.surkovr.data_structures.single_linked_list.ListItem;
import ru.list.surkovr.data_structures.single_linked_list.SingleLinkedList;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // BinaryTree test
        System.out.println("\n=== Test BinaryTree");
        Node node = new Node("5");
        BinaryTree bTree = new BinaryTree();
        System.out.println("Добавляем элемент " + node.getData() + " в дерево");
        bTree.addNode(node.getData());
        for (int i = 0; i < 20; i++) {
            String temp = String.valueOf((int) (Math.random() * 10));
            bTree.addNode(temp); // Элементы от 1 до 10 чтобы были повторения
            System.out.println("\tДобавили узел " + temp);
        }
        String randomNodeDataToSearch = String.valueOf((int) (Math.random() * 10));
        System.out.println("Ищем случайный узел: " + randomNodeDataToSearch);
        List<Node> nodes = bTree.searchNodes(randomNodeDataToSearch);
        nodes.forEach(System.out::println);
    }
}
