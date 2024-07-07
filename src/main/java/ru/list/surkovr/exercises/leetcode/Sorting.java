package ru.list.surkovr.exercises.leetcode;

import java.util.Arrays;
import java.util.Comparator;

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
}
