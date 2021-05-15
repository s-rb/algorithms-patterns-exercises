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

    /*private static void binarySearchRun(String[] stringArrayForTest) {
        System.out.println("\n=> 2. Бинарный поиск");
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(stringArrayForTest));
        BinarySearch binarySearch = new BinarySearch(arrayList);
        System.out.println("Ищем значение, которое есть в массиве");
        System.out.println(binarySearch.search("6"));
        System.out.println("Ищем значение, которое в массиве отсутствует");
        System.out.println(binarySearch.search("9"));
        System.out.println("=========== Конец теста 2. BinarySearch ============");
    }*/
}
