package ru.list.surkovr.exercises.linkedLists;

import org.junit.Test;
import ru.list.surkovr.exercises.linkedLists.singleLinkedListImpl.Node;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.list.surkovr.exercises.linkedLists.Task2findNthElementToLast.getNthElementToLast;
import static ru.list.surkovr.exercises.linkedLists.Task2findNthElementToLast.getNthElementToLast_recursive;

public class Task2findNthElementToLastTest {

    @Test
    public void getNthElementToLastTest() {
        Node list = new Node(0);
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(2);
        list.appendToTail(4);
        list.appendToTail(3);
        Node searchedItem = getNthElementToLast(4, list);
        assertThat(searchedItem).isNotNull();
        assertThat(searchedItem.getData()).isEqualTo(1);
    }

    @Test
    public void getNthElementToLast_recursiveTest() {
        Node list = new Node(0);
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(2);
        list.appendToTail(4);
        list.appendToTail(3);
        Node searchedItem = getNthElementToLast_recursive(4, list);
        assertThat(searchedItem).isNotNull();
        assertThat(searchedItem.getData()).isEqualTo(1);
    }
}
