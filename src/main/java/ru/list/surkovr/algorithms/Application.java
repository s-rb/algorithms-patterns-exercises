package ru.list.surkovr.algorithms;

import ru.list.surkovr.algorithms.rabin_karp.RabinKarpExtended;
import ru.list.surkovr.algorithms.sortAlgorithms.BubbleSortSecondImpl;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Application {

    private static final Logger log = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {

        String[] stringArrayForTest = {"1", "2", "3", "4", "5", "6", "7"};
        int[] array = new int[]{1, 2, 6, 9, 3, 0, 4, 8, 5, 7};
        String text = "CGTTACGTATGCGCTAGCTAGTCGATGATGACGACGACGACGTA";
        String query = "GATG";
        String text2 = "he rides a bike and forgot about his birthday";
        String query2 = "birthday";

        //Lets test!
//        bubbleSortRun(Arrays.copyOf(array, array.length));
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