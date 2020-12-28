package sortAlgorithms;

/**
 * Шаги:
 * Помечаем элемент (маркер), запоминаем его (начинается со второго элемента массива)
 * Начиная от данного элемента двигаемся в начало массива, сравивая маркерный элемент с текущим
 * Если текущий элемент больше или равен запомненному, то перезаписываем его (сдивгаем вправо)
 * Продолжаем пока не дойдем до конца или не найдем элемент меньше того, который запомнили
 * Т.о. каждый раз самый маленький элемент оказывается слева
 */
public class InsertSort {

    public static int[] sort(int[] src) {
        for (int marker = 1; marker < src.length; marker++) {
            int temp = src[marker]; // Запоминаем помеченный элемент
            int current = marker;
            while (current > 0 && src[current - 1] >= temp) {
                src[current] = src[current - 1];
                --current;
            }
            src[current] = temp;
        }
        return src;
    }
}
