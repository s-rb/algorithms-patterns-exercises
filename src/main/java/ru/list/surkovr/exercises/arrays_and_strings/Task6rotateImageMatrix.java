package ru.list.surkovr.exercises.arrays_and_strings;

import static java.util.Objects.isNull;

public class Task6rotateImageMatrix {

    // Task
    // Given an image represented by an NxN matrix, where each pixel in the image is 4
    //  bytes, write a method to rotate the image by 90 degrees. Can you do this in place?

    // Use M*N matrix
    public static int[][] rotateImg(int[][] srcImage) {
        if (srcImage == null || srcImage.length == 0 || srcImage[0] == null || srcImage[0].length == 0) return null;
        int newColumnsCount = srcImage.length;
        int newRowsCount = srcImage[0].length;
        int[][] res = new int[newRowsCount][newColumnsCount];
        for (int j = 0; j < newRowsCount; j++) {
            for (int i = 0; i < newColumnsCount; i++) {
                res[j][newColumnsCount - i - 1] = srcImage[i][j];
            }
        }
        return res;
    }

    // square, without using additional matrix
    public static int[][] rotateSquareImage(int[][] srcArr, int size) {
        if (srcArr == null || srcArr.length == 0 || size == 0) return null;
        for (int layer = 0; layer < size / 2; layer++) {
            int start = layer;
            int end = size - 1 - layer;
            for (int i = start; i < end; i++) {
                int offset = i - start;
                int memory = srcArr[start][i];
                srcArr[start][i] = srcArr[end - offset][start];
                srcArr[end - offset][start] = srcArr[end][end - offset];
                srcArr[end][end - offset] = srcArr[i][end];
                srcArr[i][end] = memory;
            }
        }
        return srcArr;
    }

    // square, without using additional matrix
    public static int[][] rotateSquareImage(int[][] srcArr) {
        return isNull(srcArr) ? null : rotateSquareImage(srcArr, srcArr.length);
    }
}
