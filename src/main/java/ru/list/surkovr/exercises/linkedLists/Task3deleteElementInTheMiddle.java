package ru.list.surkovr.exercises.linkedLists;

// Task
// Implement an algorithm to delete a node in the middle of a single linked list, given
//  only access to that node.


import ru.list.surkovr.exercises.linkedLists.singleLinkedListImpl.Node;

public class Task3deleteElementInTheMiddle {

    public static void delNodeFromList(Node nodeToDel, Node list) {
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
    public static boolean delNode(Node nodeToDel) {
        if (nodeToDel == null || nodeToDel.getNext() == null) return false;
        Node next = nodeToDel.getNext();
        nodeToDel.setData(next.getData());
        nodeToDel.setNext(next.getNext());
        return true;
    }
}
