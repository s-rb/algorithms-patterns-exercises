package ru.list.surkovr.exercises.linkedLists;

// Task
// Write code to remove duplicates from an unsorted linked list.
//  FOLLOW UP
//  How would you solve this problem if a temporary bu#er is not allowed?􀀁

import ru.list.surkovr.exercises.linkedLists.singleLinkedListImpl.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class Task1removeDuplicates {

    public static Node removeDuplicates(Node list) {
        if (list == null) return null;
        Map<Integer, Integer> dataCounts = new HashMap<>();
        dataCounts.put(list.getData(), 1);
        Node n = list;
        while (n.getNext() != null) {
            int key = n.getNext().getData();
            dataCounts.put(key, dataCounts.getOrDefault(key, 0) + 1);
            n = n.getNext();
        }
        int counter = 0;
        for (int key : dataCounts.keySet()) {
            int val = dataCounts.get(key);
            if (val > 1) {
                for (int i = 0; i < val - 1; i++) {
                    list = list.deleteNode(list, key);
                    counter++;
                }
            }
        }
        System.out.println("Удалено " + counter + " дубликатов");
        return list;
    }

    public static Node removeDuplicates_2impl(Node list) {
        Node head = Optional.ofNullable(list).orElseThrow();
        Node previous = head;
        Node current = head.getNext();
        while (current != null) { // Итерация до конца списка
            Node pointer = head;
            while (pointer != current) { // итерация указателем до current
                if (pointer.getData() == current.getData()) {
                    Node memory = current.getNext();
                    previous.setNext(memory);
                    current = memory;
                    break;
                }
                pointer = pointer.getNext();
            }
            if (pointer == current) {
                previous = current;
                current = current.getNext();
            }
        }
        return head;
    }

    public static void addSomeValues(Node list) {
        int counter = 0;
        for (int i = 0; i < new Random().nextInt(100) + 10; i++) {
            list.appendToTail(new Random().nextInt(10));
            counter++;
        }
        System.out.println("В лист добавлено " + counter + " элементов");
    }
}
