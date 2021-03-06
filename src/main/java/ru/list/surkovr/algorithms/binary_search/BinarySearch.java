package ru.list.surkovr.algorithms.binary_search;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

@Slf4j
public class BinarySearch {

    /**
     * Возвращает индекс найденного бинарным поиском значения в переданном отсортированном списке
     * @param list Осортированный список значений для поиска
     * @param query Знаячение которое требуется найти
     * @return Индекс найденного значения в списке или -1 в противном случае
     */
    public static int search(List<String> list, String query) {
        return search(query, 0, list.size() - 1, list);
    }

    private static int search(String query, int from, int to, List<String> list) {
        // Для бинарного поиска, требуется отсортированная коллекция. Возвращаем номер индекса в отстортированной коллекции
        // Не имеет смысла если подается ArrayList неотсортированный, поскольку полученный индекс будет указывать
        // На другой объект
        if (query == null || query.isEmpty()) {
            log.info("Строка поиска пуста");
            return -1;
        }
        Collections.sort(list);
        int middleIndex = (to + from) / 2;
        log.info("\tИндекс середины массива: " + middleIndex);
        String middleString = list.get(middleIndex);
        log.info("\tЗначение по индексу в середине массива: " + middleString);
        int stringComparator = middleString.compareTo(query);
        log.info("\tРезультат сравнения искомого значения со значением в середине массива: " + stringComparator);
        if (stringComparator == 0) {
            log.info("\tЗначение найдено в массиве по индексу: " + middleIndex);
            return middleIndex;
        } else if (from == to) { // Если остался один элемент и он не равен искомому, то такого элемента в массиве нет
            log.info("\tЭлемента в массиве нет");
            return -1;
        } else if (stringComparator < 0) { // Во второй половине находится результат
            log.info("\tИщем в большей половине массива - индексы от " + (middleIndex + 1) + " до " + to);
            return search(query, middleIndex + 1, to, list);
        } else {
            log.info("\tИщем в меньшей половине массива - индексы от " + from + " до " + (middleIndex - 1));
            return search(query, from, middleIndex - 1, list);
        }
    }
}
