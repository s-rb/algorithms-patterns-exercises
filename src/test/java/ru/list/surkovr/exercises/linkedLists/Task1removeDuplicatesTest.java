package ru.list.surkovr.exercises.linkedLists;

import org.junit.Test;
import ru.list.surkovr.exercises.linkedLists.singleLinkedListImpl.Node;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1removeDuplicatesTest {

    @Test
    public void removeDuplicatesTest() {
        Node list = new Node(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(2);
        list.appendToTail(4);
        Node actual = Task1removeDuplicates.removeDuplicates(list);
        assertThat(actual).isNotNull();
        assertThat(actual.getData()).isEqualTo(1);
        Node next1 = actual.getNext();
        assertThat(next1.getData()).isEqualTo(3);
        Node next2 = next1.getNext();
        assertThat(next2.getData()).isEqualTo(2);
        Node next3 = next2.getNext();
        assertThat(next3.getData()).isEqualTo(4);
    }

    @Test
    public void removeDuplicates_2implTest() {
        Node list = new Node(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(2);
        list.appendToTail(4);
        Node actual = Task1removeDuplicates.removeDuplicates_2impl(list);
        assertThat(actual).isNotNull();
        assertThat(actual.getData()).isEqualTo(1);
        Node next1 = actual.getNext();
        assertThat(next1.getData()).isEqualTo(2);
        Node next2 = next1.getNext();
        assertThat(next2.getData()).isEqualTo(3);
        Node next3 = next2.getNext();
        assertThat(next3.getData()).isEqualTo(4);
    }
}
