package ru.list.surkovr.exercises.arrays_and_strings;

import java.util.Arrays;
import java.util.Random;

public class Task6rotateImageMatrix {

    // Task
    // Given an image represented by an NxN matrix, where each pixel in the image is 4
    //  bytes, write a method to rotate the image by 90 degrees. Can you do this in place?

    // Use M*N matrix
    public static void main(String[] args) {
        int n = 8; // rows
        int m = 6; // columns
        int[][] srcImage = new int[n][m];
        // Some values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                srcImage[i][j] = new Random().nextInt(10);
            }
        }
        System.out.println("Source: " + Arrays.deepToString(srcImage));
        System.out.println("Source length: " + srcImage.length);

        int[][] rotImage = rotateImg(srcImage);
        System.out.println("Result length: " + rotImage.length);
        System.out.println("Result: " + Arrays.deepToString(rotImage));

        System.out.println("---------------------\nSquare matrix test");
        // Second test - square
        int size = 5;
        int[][] sqrMtrx = new int[size][size];
        // Some values
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sqrMtrx[i][j] = new Random().nextInt(10);
            }
        }
        System.out.println("Source: " + Arrays.deepToString(sqrMtrx));
        System.out.println("Source length: " + sqrMtrx.length);

        rotateSquareImage(sqrMtrx, size);
        System.out.println("Result length: " + sqrMtrx.length);
        System.out.println("Result: " + Arrays.deepToString(sqrMtrx));
    }

    private static int[][] rotateImg(int[][] srcImage) {
        if (srcImage == null || srcImage.length == 0 || srcImage[0] == null || srcImage[0].length == 0) return null;
        int newColumnsCount = srcImage.length;
        int newRowsCount = srcImage[0].length;
        int[][] res = new int[newRowsCount][newColumnsCount];
        for (int j = 0; j < newRowsCount; j++) {
            for (int i = 0; i < newColumnsCount; i++) {
                res[j][i] = srcImage[i][j];
            }
        }
        return res;
    }

    // square, without using additional matrix
    private static void rotateSquareImage (int[][] srcArr, int size) {
        if (srcArr == null || srcArr.length == 0 || size == 0) return;
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
    }
}
