package ru.list.surkovr.algorithms;

import org.junit.jupiter.api.Test;
import ru.list.surkovr.algorithms.array_max_value.ArrayMaxValue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Roman Surkov
 * @created on 15.05.2021
 */
public class ArrayMaxValueTest {

    String[] stringArrayForTest = {"1", "2", "3", "4", "5", "6", "7"};

    @Test
    public void getMaxValue() {
        int[] intArrayForTest = new int[stringArrayForTest.length];
        for (int i = 0; i < stringArrayForTest.length; i++) {
            intArrayForTest[i] = Integer.parseInt(stringArrayForTest[i]);
        }
        final int actual = ArrayMaxValue.getMaxValue(intArrayForTest);
        assertThat(actual).isNotNull().isEqualTo(7);
    }

    @Test
    public void getMaxValueEmptyArray() {
        int[] arrayForTest = {};
        Exception expected = new IllegalArgumentException("Переданный в метод массив пуст или равен null");
        try {
            ArrayMaxValue.getMaxValue(arrayForTest);
        } catch (IllegalArgumentException actual) {
            assertThat(actual).isNotNull().isEqualToComparingFieldByField(expected);
        }
    }
}
