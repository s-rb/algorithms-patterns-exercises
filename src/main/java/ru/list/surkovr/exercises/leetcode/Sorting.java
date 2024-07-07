package ru.list.surkovr.exercises.leetcode;

import java.util.*;

public class Sorting {

    /**
     * 1637. Widest Vertical Area Between Two Points Containing No Points
     * Easy
     * Topics
     * Companies
     * Hint
     * Given n points on a 2D plane where points[i] = [xi, yi], Return the widest vertical area between two points such that no points are inside the area.
     *
     * A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height). The widest vertical area is the one with the maximum width.
     *
     * Note that points on the edge of a vertical area are not considered included in the area.
     *
     *
     *
     * Example 1:
     *
     * ​
     * Input: points = [[8,7],[9,9],[7,4],[9,7]]
     * Output: 1
     * Explanation: Both the red and the blue area are optimal.
     * Example 2:
     *
     * Input: points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
     * Output: 3
     *
     *
     * Constraints:
     *
     * n == points.length
     * 2 <= n <= 105
     * points[i].length == 2
     * 0 <= xi, yi <= 109
     */
    public static int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(arr -> arr[0]));
        int max = 0;
        if (points.length < 2) return max;
        for (int i = 1; i < points.length; i++) {
            max = Math.max(max, points[i][0] - points[i-1][0]);
        }
        return max;
    }

    public static int maxWidthOfVerticalArea2(int[][] points) {
        int len = points.length;
        if (len < 2) return 0;

        int[] xAxis = new int[len];
        for (int i = 0; i < len; i++) xAxis[i] = points[i][0];

        Arrays.sort(xAxis);

        int max = 0;
        for (int i = 1; i < len; i++) max = Math.max(max, xAxis[i] - xAxis[i-1]);
        return max;
    }

    /**
     * 2545. Sort the Students by Their Kth Score
     * Medium
     * Topics
     * Companies
     * Hint
     * There is a class with m students and n exams. You are given a 0-indexed m x n integer matrix score, where each row represents one student and score[i][j] denotes the score the ith student got in the jth exam. The matrix score contains distinct integers only.
     *
     * You are also given an integer k. Sort the students (i.e., the rows of the matrix) by their scores in the kth (0-indexed) exam from the highest to the lowest.
     *
     * Return the matrix after sorting it.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: score = [[10,6,9,1],[7,5,11,2],[4,8,3,15]], k = 2
     * Output: [[7,5,11,2],[10,6,9,1],[4,8,3,15]]
     * Explanation: In the above diagram, S denotes the student, while E denotes the exam.
     * - The student with index 1 scored 11 in exam 2, which is the highest score, so they got first place.
     * - The student with index 0 scored 9 in exam 2, which is the second highest score, so they got second place.
     * - The student with index 2 scored 3 in exam 2, which is the lowest score, so they got third place.
     * Example 2:
     *
     *
     * Input: score = [[3,4],[5,6]], k = 0
     * Output: [[5,6],[3,4]]
     * Explanation: In the above diagram, S denotes the student, while E denotes the exam.
     * - The student with index 1 scored 5 in exam 0, which is the highest score, so they got first place.
     * - The student with index 0 scored 3 in exam 0, which is the lowest score, so they got second place.
     *
     *
     * Constraints:
     *
     * m == score.length
     * n == score[i].length
     * 1 <= m, n <= 250
     * 1 <= score[i][j] <= 105
     * score consists of distinct integers.
     * 0 <= k < n
     */
    public static int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (arr1, arr2) -> arr2[k] - arr1[k]);
        return score;
    }
}
