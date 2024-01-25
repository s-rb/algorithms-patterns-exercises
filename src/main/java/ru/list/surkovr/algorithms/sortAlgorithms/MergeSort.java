package ru.list.surkovr.algorithms.sortAlgorithms;

public class MergeSort {
    public static void mergeSort(int[] array) {
        int n = array.length;
        int middle = n / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[n - middle];

        for (int i = 0; i < middle; i++) {
            leftArray[i] = array[i];
        }
        for (int i = middle; i < n; i++) {
            rightArray[i - middle] = array[i];
        }
        if (leftArray.length > 1) {
            mergeSort(leftArray);
        }
        if (rightArray.length > 1) {
            mergeSort(rightArray);
        }
        merge(array, leftArray, rightArray);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        if (array.length == 1) {
            if (left.length == 1 && right.length == 0) {
                array[0] = left[0];
            } else if (right.length == 1 && left.length == 0) {
                array[0] = right[0];
            }
            return;
        }
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (leftIndex < left.length) {
                if (rightIndex == right.length) {
                    array[i] = left[leftIndex];
                    leftIndex += 1;
                } else if (left[leftIndex] < right[rightIndex]) {
                    array[i] = left[leftIndex];
                    leftIndex += 1;
                } else {
                    array[i] = right[rightIndex];
                    rightIndex += 1;
                }
            } else {
                array[i] = right[rightIndex];
                rightIndex += 1;
            }
        }
    }
}