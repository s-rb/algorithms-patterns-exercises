import array_max_value.ArrayMaxValue;
import binary_search.BinarySearch;
import bubble_sort.BubbleSort;
import merge_sort.MergeSort;
import quick_sort.QuickSort;
import rabin_karp.RabinKarpExtended;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String[] stringArrayForTest = {"1", "2", "3", "4", "5", "6", "7"};
        int[] array = new int[]{1, 2, 6, 9, 3, 0, 4, 8, 5, 7};
        String text = "CGTTACGTATGCGCTAGCTAGTCGATGATGACGACGACGACGTA";
        String query = "GATG";
        String text2 = "he rides a bike and forgot about his birthday";
        String query2 = "birthday";

        //Lets test!
        arrayMaxValueRun(stringArrayForTest);
        binarySearchRun(stringArrayForTest);
        bubbleSortRun(Arrays.copyOf(array, array.length));
        quickSortRun(Arrays.copyOf(array, array.length));
        mergeSortRun(Arrays.copyOf(array, array.length));
        rabinKarpRun(text, query);
        rabinKarpRun(text2, query2);
    }

    private static void searchTextAndPrint(RabinKarpExtended rabinKarpExtended, String query) {
            List<Integer> indices = rabinKarpExtended.search(query);
            if (indices != null) {
                System.out.println(Arrays.toString(indices.toArray()));
            } else {
                System.out.println("Указанная подстрока отсутствует или невозможно найти из-за ограничения алфавита в поиске");
            }
    }

    private static void arrayMaxValueRun(String[] stringArrayForTest) {
        int[] arrayForTest = {};
        try {
            System.out.println("\n=> 1. Поиск наибольшего значения. \nНа вход передается пустой массив: ");
            System.out.println(ArrayMaxValue.getMaxValue(arrayForTest));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        int[] intArrayForTest = new int[stringArrayForTest.length];
        for (int i = 0; i < stringArrayForTest.length; i++) {
            intArrayForTest[i] = Integer.parseInt(stringArrayForTest[i]);
        }
        System.out.println("Поиск наибольшего значения, массив заполнен валидными данными");
        System.out.println(ArrayMaxValue.getMaxValue(intArrayForTest));
        System.out.println("=========== Конец теста 1. ArrayMaxValue ============");
    }

    private static void binarySearchRun(String[] stringArrayForTest) {
        System.out.println("\n=> 2. Бинарный поиск");
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(stringArrayForTest));
        BinarySearch binarySearch = new BinarySearch(arrayList);
        System.out.println("Ищем значение, которое есть в массиве");
        System.out.println(binarySearch.search("6"));
        System.out.println("Ищем значение, которое в массиве отсутствует");
        System.out.println(binarySearch.search("9"));
        System.out.println("=========== Конец теста 2. BinarySearch ============");
    }

    private static void bubbleSortRun(int[] array) {
        System.out.println("\n=> 3. BubbleSort");
        BubbleSort.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("=========== Конец теста 3 ============");
    }

    private static void quickSortRun(int[] array) {
        System.out.println("\n=> 4. QuickSort");
        QuickSort.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("=========== Конец теста 4 ============");
    }

    private static void mergeSortRun(int[] array) {
        System.out.println("\n=> 5. MergeSort");
        MergeSort.mergeSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("=========== Конец теста 5 ============");
    }

    private static void rabinKarpRun(String text, String query) {
        System.out.println("\n=> 6. Рабин-Карп");
        String emptyQuery = "";
        try {
            System.out.println("Поиск подстроки по Рабину-Карпу. \nНа вход передается пустой запрос: ");
            searchTextAndPrint(new RabinKarpExtended(text), emptyQuery);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            System.out.println("==== Поиск подстроки " + query);
            searchTextAndPrint(new RabinKarpExtended(text), query);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

/*
Сложность некоторых запросов:
- Поиск минимального значения в массиве чисел длиной n, который отсортирован по возрастанию.
==>  O(1), т.к. известно что мин.значение в начале и обратиться можем по индексу

- Расчёт среднего значения в массиве чисел длиной n.
==> O(n), так как нужно обратиться к каждому числу, чтобы сложить и затем в одно действие разделить на общее количество

- Получение длины массива размером n.
==> O(1) массивы при создании имеют известный размер, который не меняется

- Задан список из n объектов, каждый из которых представляет собой банковский счёт - ArrayList<Bill>.
И есть класс и метод, с помощью которых можно получить общую сумму транзакций между первым и вторым счётом -
TransactionsCalculator.calculateTotalSum(Bill sourceBill, Bill destinationBill).
Алгоритм должен, используя этот метод, посчитать общую сумму переводов между всеми счетами из списка.
==> Попарно сложить все данные между каждой парой счетов - потребуется (n-1)! операций. Сложность составит O(n)
 */