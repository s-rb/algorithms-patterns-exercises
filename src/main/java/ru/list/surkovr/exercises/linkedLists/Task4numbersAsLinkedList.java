package ru.list.surkovr.exercises.linkedLists;

// You have two numbers represented by a linked list, where each node contains a single
//  digit. The digits are stored in reverse order, such that the 1’s digit is at the head of
//  the list. Write a function that adds the two numbers and returns the sum as a linked
//  list.
//  EXAMPLE
//  Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
//  Output: 8 -> 0 -> 8

// Есть два числа, каждое из которых представлено как LinkedList, внутри которого элементом являются
// каждая цифра. Элементы располагаются в обратном порядке.
// Написать функцию, которая добавляет два цисла и возвращает сумму чисел как линкед лист.


import ru.list.surkovr.exercises.linkedLists.singleLinkedListImpl.Node;

public class Task4numbersAsLinkedList {

    public static Node getSumNode(Node number1, Node number2) {
        if (number1 == null && number2 == null) return null;
        return calculateSumNodes(number1, number2, 0);
    }

    public static Node calculateSumNodes(Node num1, Node num2, int valueInMemory) {
        if (num1 == null && num2 == null) return null;
        Node res = new Node(valueInMemory);
        int currentValue = valueInMemory;
        if (num1 != null) currentValue += num1.getData();
        if (num2 != null) currentValue += num2.getData();
        res.setData(currentValue % 10);
        res.setNext(calculateSumNodes(
                num1 == null ? null : num1.getNext(),
                num2 == null ? null : num2.getNext(),
                currentValue >= 10 ? 1 : 0));
        return res;
    }
}
