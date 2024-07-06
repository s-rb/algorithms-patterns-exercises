package ru.list.surkovr.algorithms.sortAlgorithms;

public class CountingSort {

    /**
     * here is clear explanation
     * https://www.baeldung.com/java-counting-sort
     * 1st implementation
     * Only for non-negative numbers
     */
    public static int[] sort(int[] src) {
        int[] temp = new int[getMax(src)+1];
        for (int element : src) temp[element]++; // store count for elements
        for (int i = 1; i < temp.length; i++) { // store accumulated count for elements for each index
            temp[i] = temp[i] + temp[i - 1];
        }
        // and lets sort for reversed source array
        int[] res = new int[src.length];
        for (int i = src.length - 1; i >= 0; i--) {
            int element = src[i];
            int idx = temp[element]-- - 1;
            res[idx] = element;
        }
        return res;
    }

    private static int getMax(int[] src) {
        int max = 0;
        for (int el : src) max = Math.max(max, el);
        return max;
    }
}
