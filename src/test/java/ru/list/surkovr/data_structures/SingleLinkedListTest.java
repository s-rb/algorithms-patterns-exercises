package ru.list.surkovr.data_structures;

import org.junit.Test;
import ru.list.surkovr.data_structures.single_linked_list.ListItem;
import ru.list.surkovr.data_structures.single_linked_list.SingleLinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleLinkedListTest {

    @Test
    public void pushTest() {
        ListItem sItem = new ListItem("1");
        SingleLinkedList sList = new SingleLinkedList();
        assertThat(sList).isNotNull();
        assertThat(sList.getTop()).isNull();
        sList.push(sItem);
        assertThat(sList.getTop()).isNotNull().isEqualToComparingFieldByField(sItem);
    }

    @Test
    public void pushSeveralItemsTest() {
        ListItem sItem = new ListItem("1");
        ListItem sItem2 = new ListItem("2");
        ListItem sItem3 = new ListItem("3");
        SingleLinkedList sList = new SingleLinkedList();
        assertThat(sList).isNotNull();
        assertThat(sList.getTop()).isNull();
        sList.push(sItem);
        sList.push(sItem2);
        sList.push(sItem3);
        assertThat(sList.getTop()).isNotNull().isEqualToComparingFieldByField(sItem3);
    }

    @Test
    public void popTest() {
        ListItem sItem = new ListItem("1");
        ListItem sItem2 = new ListItem("2");
        ListItem sItem3 = new ListItem("3");
        SingleLinkedList sList = new SingleLinkedList();
        assertThat(sList).isNotNull();
        assertThat(sList.getTop()).isNull();
        sList.push(sItem);
        sList.push(sItem2);
        sList.push(sItem3);
        assertThat(sList.getTop()).isNotNull().isEqualToComparingFieldByField(sItem3);
        ListItem actual = sList.pop();
        assertThat(actual).isNotNull().isEqualToComparingFieldByField(sItem3);
        assertThat(sList.getTop()).isNotNull().isEqualToComparingFieldByField(sItem2);
    }

    @Test
    public void removeTopTest() {
        ListItem sItem = new ListItem("1");
        ListItem sItem2 = new ListItem("2");
        ListItem sItem3 = new ListItem("3");
        SingleLinkedList sList = new SingleLinkedList();
        assertThat(sList).isNotNull();
        assertThat(sList.getTop()).isNull();
        sList.push(sItem);
        sList.push(sItem2);
        sList.push(sItem3);
        assertThat(sList.getTop()).isNotNull().isEqualToComparingFieldByField(sItem3);
        sList.removeTop();
        assertThat(sList.getTop()).isNotNull().isEqualToComparingFieldByField(sItem2);
    }

    @Test
    public void removeLastTest() {
        ListItem sItem = new ListItem("1");
        ListItem sItem2 = new ListItem("2");
        ListItem sItem3 = new ListItem("3");
        SingleLinkedList sList = new SingleLinkedList();
        assertThat(sList).isNotNull();
        assertThat(sList.getTop()).isNull();
        sList.push(sItem);
        sList.push(sItem2);
        sList.push(sItem3);
        assertThat(sList.getTop()).isNotNull().isEqualToComparingFieldByField(sItem3);
        sList.removeLast();
        sList.removeTop();
        assertThat(sList.getTop()).isNotNull().isEqualToComparingFieldByField(sItem2);
        sList.removeTop();
        assertThat(sList.getTop()).isNull();
    }
}
