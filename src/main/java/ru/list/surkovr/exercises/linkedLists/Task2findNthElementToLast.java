package ru.list.surkovr.exercises.linkedLists;

import ru.list.surkovr.exercises.linkedLists.singleLinkedListImpl.Node;

import java.util.Objects;

public class Task2findNthElementToLast {

    public static Node getNthElementToLast(int n, Node list) {
        Node pointerMain = Objects.requireNonNull(list);
        Node pointerHelp = pointerMain;
        int counter = 0;
        while (counter < n) {
            Node tmp = pointerHelp.getNext();
            if (tmp == null) return null;
            pointerHelp = tmp;
            counter++;
        }
        while (pointerHelp.getNext() != null) {
            pointerHelp = pointerHelp.getNext();
            pointerMain = pointerMain.getNext();
        }
        return pointerMain;
    }

    public static Node getNthElementToLast_recursive(int n, Node list) {
        if (list == null) return null;
        Node head = list;
        Node prelast = head;
        Node last = head.getNext();
        if (last == null) return null;
        while (last.getNext() != null) {
            prelast = last;
            last = last.getNext();
        }
        if (n == 1) return prelast;
        prelast.setNext(null);
        return getNthElementToLast_recursive(n - 1, head);
    }
}
