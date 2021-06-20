package ru.list.surkovr.exercises.arrays_and_strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static ru.list.surkovr.exercises.arrays_and_strings.Task6rotateImageMatrix.rotateImg;
import static ru.list.surkovr.exercises.arrays_and_strings.Task6rotateImageMatrix.rotateSquareImage;

public class Task6RotateImageMatrixTest {

    public static final Random RANDOM = new Random();

    @Test
    public void rotateImage_MxN_360Degrees() {
        int n = 8; // rows
        int m = 6; // columns
        int[][] srcImage = new int[n][m];
        // Some values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                srcImage[i][j] = RANDOM.nextInt(10);
            }
        }
        int[][] actual = rotateImg(rotateImg(rotateImg(rotateImg(srcImage))));
        Assertions.assertThat(actual).isEqualTo(srcImage);
    }

    @Test
    public void rotateImage_MxN() {
        int[][] srcImage = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        int[][] expected = new int[][]{
                {10, 7, 4, 1},
                {11, 8, 5, 2},
                {12, 9, 6, 3}
        };
        int[][] actual = rotateImg(srcImage);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void rotateImageNull() {
        int[][] srcImage = null;
        int[][] actual = rotateImg(srcImage);
        Assertions.assertThat(actual).isNull();
    }

    @Test
    public void rotateImageEmpty() {
        int[][] srcImage = new int[][]{};
        int[][] actual = rotateImg(srcImage);
        Assertions.assertThat(actual).isNull();
    }

    @Test
    public void rotateImageSquare360Degrees() {
        int n = 6; // rows
        int m = 6; // columns
        int[][] srcImage = new int[n][m];
        // Some values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                srcImage[i][j] = RANDOM.nextInt(10);
            }
        }
        int[][] actual = rotateSquareImage(rotateSquareImage(rotateSquareImage(rotateSquareImage(srcImage))));
        Assertions.assertThat(actual).isEqualTo(srcImage);
    }

    @Test
    public void rotateImageSquareTest() {
        int[][] srcImage = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expected = new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        int[][] actual = rotateSquareImage(srcImage);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void rotateImageSquareNull() {
        int[][] srcImage = null;
        int[][] actual = rotateSquareImage(srcImage);
        Assertions.assertThat(actual).isNull();
    }

    @Test
    public void rotateImageSquareEmpty() {
        int[][] srcImage = new int[][]{};
        int[][] actual = rotateSquareImage(srcImage);
        Assertions.assertThat(actual).isNull();
    }
}
