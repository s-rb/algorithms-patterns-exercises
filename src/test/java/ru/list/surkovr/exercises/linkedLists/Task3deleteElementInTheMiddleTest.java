package ru.list.surkovr.exercises.linkedLists;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import ru.list.surkovr.exercises.linkedLists.singleLinkedListImpl.Node;

import static ru.list.surkovr.exercises.linkedLists.Task3deleteElementInTheMiddle.delNode;
import static ru.list.surkovr.exercises.linkedLists.Task3deleteElementInTheMiddle.delNodeFromList;

public class Task3deleteElementInTheMiddleTest {

    @Test
    public void delNodeFromListTest() {
        Node list = new Node(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(4);
        list.appendToTail(5);
        Node nodeToDel = list.getNext().getNext();
        int deletedData = nodeToDel.getData();
        delNodeFromList(nodeToDel, list);
        Node node = list;
        while (node != null) {
            Assertions.assertThat(node.getData()).isNotEqualTo(deletedData);
            node = node.getNext();
        }
    }

    @Test
    public void delNodeTest() {
        Node list = new Node(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(4);
        list.appendToTail(5);
        Node nodeToDel = list.getNext();
        int deletedData = nodeToDel.getData();
        delNode(nodeToDel);
        Node node = list;
        while (node != null) {
            Assertions.assertThat(node.getData()).isNotEqualTo(deletedData);
            node = node.getNext();
        }
    }
}