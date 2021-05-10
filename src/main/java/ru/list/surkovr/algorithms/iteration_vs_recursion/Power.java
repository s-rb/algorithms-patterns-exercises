package ru.list.surkovr.algorithms.iteration_vs_recursion;

// Возведение в степень с помощью умножения и рекурсии
public class Power {

    public static int getPowered(int src, int pow) {
        if (pow == 1) {
            return src;
        } else {
            int powered = getPowered(src * src, pow / 2);
            return pow % 2 == 0 ? powered : powered * src;
        }
    }
}
