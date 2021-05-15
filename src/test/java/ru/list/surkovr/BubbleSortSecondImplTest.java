package ru.list.surkovr;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.list.surkovr.algorithms.sortAlgorithms.BubbleSortSecondImpl;

import static org.assertj.core.api.Assertions.assertThat;

public class BubbleSortSecondImplTest {

    int[] array;
    int[] arrayNull;
    int[] arrayEmpty;

    @BeforeAll
    public void setUp() throws Exception {
        array = new int[]{1, 2, 6, 9, 3, 0, 4, 8, 5, 7};
        arrayNull = null;
        arrayEmpty = new int[]{};
    }

    @AfterAll
    public void tearDown() throws Exception {
    }

    @Test
    public void sort() {
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] actual = BubbleSortSecondImpl.sort(array);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void sort_NULL_ARRAY() {
        try {
            BubbleSortSecondImpl.sort(arrayNull);
        } catch (Exception actual) {
            Exception expected = new NullPointerException("В метод передан объект null");
            assertThat(actual).isNotNull().isEqualToComparingFieldByField(expected);
        }
    }

    @Test
    public void sort_EMPTY_ARRAY() { // сортируется также как и обычный заполненный массив
        int[] expected = {};
        int[] actual = BubbleSortSecondImpl.sort(arrayEmpty);
        Assertions.assertThat(actual).isNotNull().containsExactly(expected);
    }
}