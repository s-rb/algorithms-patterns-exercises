package ru.list.surkovr.linkedLists;

// Task
// Implement an algorithm to delete a node in the middle of a single linked list, given
//  only access to that node.

import ru.list.surkovr.linkedLists.singleLinkedListImpl.Node;

public class Task3deleteElementInTheMiddle {

    public static void main(String[] args) {

        Node list = new Node(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(4);
        list.appendToTail(5);
        Node nodeToDel = list.getNext().getNext();
        System.out.println("nodeToDel: " + nodeToDel.getData());
        System.out.println("list: " + list);
        delNodeFromList(nodeToDel, list);
        System.out.println("list after del: " + list);
        System.out.println("---------------------\nDelete node having only the link to that node");
        System.out.println("Src list: " + list);
        nodeToDel = list.getNext();
        System.out.println("Node to del: " + nodeToDel.getData());
        System.out.println(delNode(nodeToDel) ? "New list: " + list : "Не удалось удалить элемент!");
    }

    private static void delNodeFromList(Node nodeToDel, Node list) {
        // считаем, что nodeToDel не последний и не первый
        if (nodeToDel == null || list == null || nodeToDel.getNext() == null || list == nodeToDel) return;
        Node prev = list;
        Node current = prev.getNext();
        while (current != nodeToDel) {
            prev = current;
            current = current.getNext();
        }
        prev.setNext(current.getNext());
    }

    // удаление элемента из списка, имея доступ только к этому элементу
    // Копируем данные из следующего элемента в текущий, а также меняем ссылку
    private static boolean delNode(Node nodeToDel) {
        if (nodeToDel == null || nodeToDel.getNext() == null) return false;
        Node next = nodeToDel.getNext();
        nodeToDel.setData(next.getData());
        nodeToDel.setNext(next.getNext());
        return true;
    }
}
