package sortAlgorithms;

/**
 * Последовательный перебор и сравнение текущего элемента с остальными
 * Самый маленький запоминается. Итоговый запомненный элемент меняется местами с текущим
 */
public class SelectSort {

    public static int[] sort(int[] src) {
        for (int i = 0; i < src.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < src.length; j++) {
                if (src[j] < src[min]) {
                    min = j;
                }
            }
            // Меняем местами исходный элемент и минимальный
            int temp = src[i];
            src[i] = src[min];
            src[min] = temp;
        }
        return src;
    }
}
