package ru.list.surkovr.algorithms.sortAlgorithms;

/**
 * Сравниваем каждый раз элементы друг с другой - самый большой элемент переносится вправо
 */
public class BubbleSort {

    public static int[] sort(int[] src) {
        for (int i = 0; i < src.length - 1; i++) {
            for (int j = i + 1; j < src.length; j++) {
                if (src[i] > src[j]) {
                    int temp = src[j];
                    src[j] = src[i];
                    src[i] = temp;
                }
            }
        }
        return src;
    }
}
