package ru.list.surkovr.iteration_vs_recursion.triangle;

public class TriangleCalculation {

    public static int calculateRecursive(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n could not be less then 1");
        }
        if (n == 1) {
            return 1;
        }
        int res = 0;
        res = n + calculateRecursive(n - 1);
        return res;
    }

    public static int calculateIterative(int n) {
        int res = 0;
        while (n > 0) {
            res += n;
            n--;
        }
        return res;
    }
}
