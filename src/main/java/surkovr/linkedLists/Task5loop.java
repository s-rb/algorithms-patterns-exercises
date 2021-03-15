package surkovr.linkedLists;

//  Task
//  Given a circular linked list, implement an algorithm which returns node at the beginning
//  of the loop.
//  DEFINITION
//  Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an
//  earlier node, so as to make a loop in the linked list.
//  EXAMPLE
//  input: A -> B -> C -> D -> E -> C [the same C as earlier]
//  output: C

import surkovr.linkedLists.singleLinkedListImpl.Node;

import java.util.HashSet;
import java.util.Set;

public class Task5loop {

    public static void main(String[] args) {

        Node list = new Node(1);
        for (int i = 2; i < 7; i++) list.appendToTail(i);
        System.out.println("Src list: " + list);
        Node last;
        Node current = list.getNext();
        while (current.getNext() != null) {
            current = current.getNext();
        }
        last = current;
        last.setNext(list.getNext().getNext());
        System.out.println("Last looped: " + last.getData() + ", points: " + last.getNext().getData());
        Node loopedNode = getLoopedNode(list);
        System.out.println(loopedNode != null ? "Looped node: "
                + " {" + loopedNode.getData() + "}" : "There is no loop in the list");
        System.out.println("================\n2Impl:");
        System.out.println("Last looped: " + last.getData() + ", points: " + last.getNext().getData());
        loopedNode = getLoopedNode_2Impl(list);
        System.out.println(loopedNode != null ? "Looped node: "
                + " {" + loopedNode.getData() + "}" : "There is no loop in the list");
    }

    private static Node getLoopedNode(Node list) {
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

    private static Node getLoopedNode_2Impl(Node head) {
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
