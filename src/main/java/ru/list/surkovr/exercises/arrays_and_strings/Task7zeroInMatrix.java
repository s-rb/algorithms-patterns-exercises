package ru.list.surkovr.exercises.arrays_and_strings;

// Task
// Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
//  column is set to 0.

import static java.util.Objects.isNull;

public class Task7zeroInMatrix {

    public static int[][] checkAndReplaceZero(int[][] src) {
        if (isNull(src) || src.length == 0 || src[0].length == 0) return null;
        int n = src.length;
        int m = src[0].length;
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
        return src;
    }

    // Store not all matrix, but only number of rows and columns with 0
    public static int[][] checkAndReplcaceZeros_2impl(int[][] src) {
        if (isNull(src) || src.length == 0 || src[0].length == 0) return null;
        int n = src.length;
        int m = src[0].length;
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
        return src;
    }
}
