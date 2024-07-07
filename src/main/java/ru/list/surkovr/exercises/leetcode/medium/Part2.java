package ru.list.surkovr.exercises.leetcode.medium;

public class Part2 {

    static int[][] directions = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
    public static int getMaximumGold(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                res = Math.max(backtrack(grid, i, j), res);
            }
        }
        return res;
    }

    private static int backtrack(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return 0;
        int temp = grid[i][j];
        grid[i][j] = 0;
        int tempSum = 0;
        for (int k = 0; k < 4; k++) {
            tempSum = Math.max(tempSum, backtrack(grid, i + directions[k][0], j + directions[k][1]));
        }
        grid[i][j] = temp;
        return temp + tempSum;
    }
}
