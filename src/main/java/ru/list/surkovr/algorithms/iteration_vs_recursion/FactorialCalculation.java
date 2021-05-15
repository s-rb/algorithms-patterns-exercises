package ru.list.surkovr.algorithms.iteration_vs_recursion;

public class FactorialCalculation {
    public static long calculateIterative(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("n value cannot be negative!");
        }
        long result = 1;
        for (long i = n; i > 1; i--) {
            result = result * i;
        }
        return result;
    }

    public static long calculateRecursive(long n) {
        return (n <= 1) ? 1 :
                n * calculateRecursive(n - 1);
    }
}
