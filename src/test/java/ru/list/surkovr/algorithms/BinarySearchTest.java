package ru.list.surkovr.algorithms;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.list.surkovr.algorithms.binary_search.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Roman Surkov
 * @created on 15.05.2021
 */
public class BinarySearchTest {

    private String[] stringArrayForTest;

    @BeforeEach
    private void init() {
        stringArrayForTest = new String[]{"1", "2", "3", "4", "5", "6", "7"};
    }

    @Test
    public void searchTest() {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(stringArrayForTest));
        final int actual = BinarySearch.search(arrayList, "6");
        Assertions.assertThat(actual).isEqualTo(5);
    }

    @Test
    public void searchTestWrongValue() {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(stringArrayForTest));
        final int actual = BinarySearch.search(arrayList, "9");
        Assertions.assertThat(actual).isEqualTo(-1);
    }
}
