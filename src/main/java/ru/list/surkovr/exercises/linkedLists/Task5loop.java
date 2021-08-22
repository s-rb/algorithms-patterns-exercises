package ru.list.surkovr.exercises.linkedLists;

//  Task
//  Given a circular linked list, implement an algorithm which returns node at the beginning
//  of the loop.
//  DEFINITION
//  Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an
//  earlier node, so as to make a loop in the linked list.
//  EXAMPLE
//  input: A -> B -> C -> D -> E -> C [the same C as earlier]
//  output: C


import ru.list.surkovr.exercises.linkedLists.singleLinkedListImpl.Node;

import java.util.HashSet;
import java.util.Set;

public class Task5loop {

    public static Node getLoopedNode(Node list) {
        if (list == null) return null;
        Set<Node> nodes = new HashSet<>();
        Node current = list;
        while (current.getNext() != null) {
            if (nodes.contains(current)) return current;
            nodes.add(current);
            current = current.getNext();
        }
        return null;
    }

    public static Node getLoopedNode_2Impl(Node head) {
        // Some checks
        if (head == null || head.getNext() == null || head.getNext().getNext() == null) return null;
        if (head.getNext() == head || head.getNext().getNext() == head) return head;
        Node pointer1 = head;
        Node pointer2 = head;
        while (pointer2.getNext() != null) {
            pointer1 = pointer1.getNext();
            pointer2 = pointer2.getNext().getNext();
            if (pointer1 == pointer2) break;
        }
        if (pointer2.getNext() == null) return null;
        pointer1 = head;
        while (pointer1 != pointer2) {
            pointer1 = pointer1.getNext();
            pointer2 = pointer2.getNext();
        }
        return pointer1;
    }
}
