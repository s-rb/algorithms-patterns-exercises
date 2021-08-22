package ru.list.surkovr.exercises.linkedLists;

import org.junit.jupiter.api.Test;
import ru.list.surkovr.exercises.linkedLists.singleLinkedListImpl.Node;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.list.surkovr.exercises.linkedLists.Task5loop.getLoopedNode;
import static ru.list.surkovr.exercises.linkedLists.Task5loop.getLoopedNode_2Impl;

public class Task5LoopTest {

    @Test
    public void getLoopedNodeTest() {
        Node list = new Node(1);
        for (int i = 2; i < 7; i++) list.appendToTail(i);
        Node last;
        Node current = list.getNext();
        while (current.getNext() != null) {
            current = current.getNext();
        }
        last = current;
        last.setNext(list.getNext().getNext());

        Node loopedNode = getLoopedNode(list);

        assertThat(loopedNode).isNotNull();
        assertThat(loopedNode.getData()).isEqualTo(3);
    }

    @Test
    public void getLoopedNode_2ImplTest() {
        Node list = new Node(1);
        for (int i = 2; i < 7; i++) list.appendToTail(i);
        Node last;
        Node current = list.getNext();
        while (current.getNext() != null) {
            current = current.getNext();
        }
        last = current;
        last.setNext(list.getNext().getNext());

        Node loopedNode = getLoopedNode_2Impl(list);

        assertThat(loopedNode).isNotNull();
        assertThat(loopedNode.getData()).isEqualTo(3);
    }
}
