package ru.list.surkovr.algorithms.sortAlgorithms;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BubbleSortSecondImplTest {

    private static int[] array;
    private static int[] arrayNull;
    private static int[] arrayEmpty;

    @BeforeAll
    public static void setUp() throws Exception {
        array = new int[]{1, 2, 6, 9, 3, 0, 4, 8, 5, 7};
        arrayNull = null;
        arrayEmpty = new int[]{};
    }

    @AfterAll
    public static void tearDown() throws Exception {
    }

    @Test
    public void sort() {
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] actual = BubbleSortSecondImpl.sort(array);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void sortNullArray() {
        try {
            BubbleSortSecondImpl.sort(arrayNull);
        } catch (Exception actual) {
            Exception expected = new NullPointerException("В метод передан объект null");
            assertThat(actual).isNotNull().isEqualToComparingFieldByField(expected);
        }
    }

    @Test
    public void sortEmptyArray() { // сортируется также как и обычный заполненный массив
        int[] expected = {};
        int[] actual = BubbleSortSecondImpl.sort(arrayEmpty);
        Assertions.assertThat(actual).isNotNull().containsExactly(expected);
    }

    @Test
    public void sort2() {
        int[] array = new int[]{1, 2, 6, 9, 3, 0, 4, 8, 5, 7};
        int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        BubbleSortSecondImpl.sort(array);
        Assertions.assertThat(array).containsExactly(expected);
    }
}