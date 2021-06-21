package ru.list.surkovr.exercises.arrays_and_strings;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.list.surkovr.exercises.arrays_and_strings.Task7zeroInMatrix.checkAndReplaceZero;
import static ru.list.surkovr.exercises.arrays_and_strings.Task7zeroInMatrix.checkAndReplcaceZeros_2impl;

public class Task7ZeroInMatrixTest {

    public static final Random RANDOM = new Random();

    @Test
    public void checkAndReplaceZeroTest() {
        int n = 4; // rows
        int m = 5; // columns
        int[][] src = new int[n][m];
        addRandomNotZeroValuesToIntArray(src, n, m);
        int zeroIndexI = 1;
        int zeroIndexJ = 2;
        src[zeroIndexI][zeroIndexJ] = 0;

        int[][] actual = checkAndReplaceZero(src);

        assertThat(actual).isNotNull();
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[0].length; j++) {
                if (i == zeroIndexI || j == zeroIndexJ) {
                    assertThat(actual[i][j]).isEqualTo(0);
                } else {
                    assertThat(actual[i][j]).isNotEqualTo(0);
                }
            }
        }
    }

    @Test
    public void checkAndReplaceZero_2ImplTest() {
        int n = 4; // rows
        int m = 5; // columns
        int[][] src = new int[n][m];
        addRandomNotZeroValuesToIntArray(src, n, m);
        int zeroIndexI = 1;
        int zeroIndexJ = 2;
        src[zeroIndexI][zeroIndexJ] = 0;

        int[][] actual = checkAndReplcaceZeros_2impl(src);

        assertThat(actual).isNotNull();
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[0].length; j++) {
                if (i == zeroIndexI || j == zeroIndexJ) {
                    assertThat(actual[i][j]).isEqualTo(0);
                } else {
                    assertThat(actual[i][j]).isNotEqualTo(0);
                }
            }
        }
    }

    @Test
    public void checkAndReplaceZeroTestNull() {
        int[][] src = null;
        int[][] actual = checkAndReplaceZero(src);
        assertThat(actual).isNull();
    }

    @Test
    public void checkAndReplaceZeroTestEmpty() {
        int[][] src = new int[][]{};
        int[][] actual = checkAndReplaceZero(src);
        assertThat(actual).isNull();
    }

    @Test
    public void checkAndReplaceZero_2ImplTestNull() {
        int[][] src = null;
        int[][] actual = checkAndReplcaceZeros_2impl(src);
        assertThat(actual).isNull();
    }

    @Test
    public void checkAndReplaceZero_2ImplTestEmpty() {
        int[][] src = new int[][]{};
        int[][] actual = checkAndReplcaceZeros_2impl(src);
        assertThat(actual).isNull();
    }

    private static void addRandomNotZeroValuesToIntArray(int[][] src, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int i1;
                do {
                    i1 = RANDOM.nextInt(10);
                } while (i1 == 0);
                src[i][j] = i1;
            }
        }
    }
}
