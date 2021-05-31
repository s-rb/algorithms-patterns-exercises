package ru.list.surkovr.data_structures;

import org.junit.Test;
import ru.list.surkovr.data_structures.double_linked_list.DoubleLinkedList;
import ru.list.surkovr.data_structures.double_linked_list.ListItem;

import static org.assertj.core.api.Assertions.assertThat;

public class DoubleLinkedListTest {

    @Test
    public void addToHead() {
        ListItem item = new ListItem("1");
        ListItem item2 = new ListItem("2");
        DoubleLinkedList list = new DoubleLinkedList();
        assertThat(list).isNotNull();
        assertThat(list.getHead()).isNull();
        assertThat(list.getTail()).isNull();
        list.addToHead(item);
        assertThat(list.getHead()).isNotNull().isEqualToComparingFieldByField(item);
        list.addToHead(item2);
        assertThat(list.getHead()).isNotNull().isEqualToComparingFieldByField(item2);
        assertThat(list.getTail()).isNotNull().isEqualToComparingFieldByField(item);
    }

    @Test
    public void addToTail() {
        ListItem item = new ListItem("1");
        ListItem item2 = new ListItem("2");
        DoubleLinkedList list = new DoubleLinkedList();
        assertThat(list).isNotNull();
        assertThat(list.getHead()).isNull();
        assertThat(list.getTail()).isNull();
        list.addToTail(item);
        assertThat(list.getTail()).isNotNull().isEqualToComparingFieldByField(item);
        list.addToTail(item2);
        assertThat(list.getTail()).isNotNull().isEqualToComparingFieldByField(item2);
        assertThat(list.getHead()).isNotNull().isEqualToComparingFieldByField(item);
    }

    @Test
    public void popHeadElement() {
        ListItem item = new ListItem("1");
        ListItem item2 = new ListItem("2");
        DoubleLinkedList list = new DoubleLinkedList();
        assertThat(list).isNotNull();
        assertThat(list.getHead()).isNull();
        assertThat(list.getTail()).isNull();
        list.addToHead(item);
        assertThat(list.getHead()).isNotNull().isEqualToComparingFieldByField(item);
        list.addToHead(item2);
        assertThat(list.getHead()).isNotNull().isEqualToComparingFieldByField(item2);
        assertThat(list.getTail()).isNotNull().isEqualToComparingFieldByField(item);
        ListItem actual = list.popHeadElement();
        assertThat(actual).isNotNull().isEqualToComparingFieldByField(item2);
        ListItem actual2 = list.popHeadElement();
        assertThat(actual2).isNotNull().isEqualToComparingFieldByField(item);
        ListItem actual3 = list.popHeadElement();
        assertThat(actual3).isNull();
    }

    @Test
    public void popTailElement() {
        ListItem item = new ListItem("1");
        ListItem item2 = new ListItem("2");
        DoubleLinkedList list = new DoubleLinkedList();
        assertThat(list).isNotNull();
        assertThat(list.getHead()).isNull();
        assertThat(list.getTail()).isNull();
        list.addToHead(item);
        assertThat(list.getHead()).isNotNull().isEqualToComparingFieldByField(item);
        list.addToHead(item2);
        assertThat(list.getHead()).isNotNull().isEqualToComparingFieldByField(item2);
        assertThat(list.getTail()).isNotNull().isEqualToComparingFieldByField(item);
        ListItem actual = list.popTailElement();
        assertThat(actual).isNotNull().isEqualToComparingFieldByField(item);
        ListItem actual2 = list.popTailElement();
        assertThat(actual2).isNotNull().isEqualToComparingFieldByField(item2);
        ListItem actual3 = list.popTailElement();
        assertThat(actual3).isNull();
    }

    @Test
    public void removeHead() {
        ListItem item = new ListItem("1");
        ListItem item2 = new ListItem("2");
        DoubleLinkedList list = new DoubleLinkedList();
        assertThat(list).isNotNull();
        assertThat(list.getHead()).isNull();
        assertThat(list.getTail()).isNull();
        list.addToHead(item);
        assertThat(list.getHead()).isNotNull().isEqualToComparingFieldByField(item);
        list.addToHead(item2);
        assertThat(list.getHead()).isNotNull().isEqualToComparingFieldByField(item2);
        assertThat(list.getTail()).isNotNull().isEqualToComparingFieldByField(item);

        list.removeHeadElement();
        assertThat(list.getHead()).isNotNull().isEqualToComparingFieldByField(item);
        list.removeHeadElement();
        assertThat(list.getHead()).isNull();
    }

    @Test
    public void removeTail() {
        ListItem item = new ListItem("1");
        ListItem item2 = new ListItem("2");
        DoubleLinkedList list = new DoubleLinkedList();
        assertThat(list).isNotNull();
        assertThat(list.getHead()).isNull();
        assertThat(list.getTail()).isNull();
        list.addToHead(item);
        assertThat(list.getHead()).isNotNull().isEqualToComparingFieldByField(item);
        list.addToHead(item2);
        assertThat(list.getHead()).isNotNull().isEqualToComparingFieldByField(item2);
        assertThat(list.getTail()).isNotNull().isEqualToComparingFieldByField(item);

        list.removeTailElement();
        assertThat(list.getTail()).isNotNull().isEqualToComparingFieldByField(item2);
        list.removeTailElement();
        assertThat(list.getTail()).isNull();
    }
}
