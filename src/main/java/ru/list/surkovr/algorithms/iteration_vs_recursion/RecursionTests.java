package ru.list.surkovr.algorithms.iteration_vs_recursion;

import static java.util.logging.Level.INFO;

public class RecursionTests {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RecursionTests.class.getName());

    public static void main(String[] args) {
        logger.log(INFO, "Recursion test:");
        logger.log(INFO, "- triangle sum for n = 1: " + TriangleNumbersCalculation.calculateRecursive(1));
        logger.log(INFO, "- triangle sum for n = 2: " + TriangleNumbersCalculation.calculateRecursive(2));
        logger.log(INFO, "- triangle sum for n = 3: " + TriangleNumbersCalculation.calculateRecursive(3));
        logger.log(INFO, "-------------------------------");
        logger.log(INFO, "Iteration test:");
        logger.log(INFO, "- triangle sum for n = 1: " + TriangleNumbersCalculation.calculateIterative(1));
        logger.log(INFO, "- triangle sum for n = 2: " + TriangleNumbersCalculation.calculateIterative(2));
        logger.log(INFO, "- triangle sum for n = 3: " + TriangleNumbersCalculation.calculateIterative(3));
    }
}