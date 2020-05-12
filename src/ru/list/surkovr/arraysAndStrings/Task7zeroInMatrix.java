package ru.list.surkovr.arraysAndStrings;

// Task
// Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
//  column is set to 0.

import java.util.Arrays;
import java.util.Random;

public class Task7zeroInMatrix {

    public static void main(String[] args) {

        int n = 4; // rows
        int m = 5; // columns
        int[][] src = new int[n][m];
        addRandomValuesToIntArray(src, n, m);
        System.out.println("Source matrix: " + Arrays.deepToString(src));
        checkAndReplaceZero(src, n, m);
        System.out.println("Result matrix: " + Arrays.deepToString(src));

        System.out.println("--------------\nSecond Impl");
        n = 4; // rows
        m = 5; // columns
        src = new int[n][m];
        addRandomValuesToIntArray(src, n, m);
        System.out.println("Source matrix: " + Arrays.deepToString(src));
        checkAndReplcaceZeros_2impl(src, n, m);
        System.out.println("Result matrix: " + Arrays.deepToString(src));
    }

    private static void checkAndReplaceZero(int[][] src, int n, int m) {
        boolean[][] isZero = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (src[i][j] == 0) {
                    for (int k = 0; k < m; k++) {
                        isZero[i][k] = true;
                    }
                    for (int l = 0; l < n; l++) {
                        isZero[l][j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isZero[i][j]) {
                    src[i][j] = 0;
                }
            }
        }
    }

    // Store not all matrix, but only number of rows and columns with 0
    private static void checkAndReplcaceZeros_2impl(int[][] src, int n, int m) {
        int[] columns = new int[m];
        int[] rows = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (src[i][j] == 0) {
                    columns[j] = 1;
                    rows[i] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rows[i] == 1 || columns[j] == 1) {
                    src[i][j] = 0;
                }
            }
        }
    }

    private static void addRandomValuesToIntArray(int[][] src, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                src[i][j] = new Random().nextInt(10);
            }
        }
    }
}
