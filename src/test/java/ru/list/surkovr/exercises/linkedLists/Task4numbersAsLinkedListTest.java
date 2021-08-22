package ru.list.surkovr.exercises.linkedLists;

import org.junit.jupiter.api.Test;
import ru.list.surkovr.exercises.linkedLists.singleLinkedListImpl.Node;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.list.surkovr.exercises.linkedLists.Task4numbersAsLinkedList.getSumNode;

public class Task4numbersAsLinkedListTest {

    @Test
    public void getSumNodeTest() {
        Node number1 = new Node(3);
        number1.appendToTail(1);
        number1.appendToTail(5);

        Node number2 = new Node(5);
        number2.appendToTail(9);
        number2.appendToTail(2);

        Node result = getSumNode(number1, number2);
        assertThat(result).isNotNull();
        assertThat(result.getData()).isEqualTo(8);
        assertThat(result.getNext().getData()).isEqualTo(0);
        assertThat(result.getNext().getNext().getData()).isEqualTo(8);
    }
}
