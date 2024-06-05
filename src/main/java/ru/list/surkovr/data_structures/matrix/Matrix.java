package ru.list.surkovr.data_structures.matrix;

public class Matrix {

    /**
     * 2373. Largest Local Values in a Matrix
     * Easy
     * Topics
     * Companies
     * Hint
     * You are given an n x n integer matrix grid.
     *
     * Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:
     *
     * maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.
     * In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.
     *
     * Return the generated matrix.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
     * Output: [[9,9],[8,6]]
     * Explanation: The diagram above shows the original matrix and the generated matrix.
     * Notice that each value in the generated matrix corresponds to the largest value of a contiguous 3 x 3 matrix in grid.
     * Example 2:
     *
     *
     * Input: grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
     * Output: [[2,2,2],[2,2,2],[2,2,2]]
     * Explanation: Notice that the 2 is contained within every contiguous 3 x 3 matrix in grid.
     *
     *
     * Constraints:
     *
     * n == grid.length == grid[i].length
     * 3 <= n <= 100
     * 1 <= grid[i][j] <= 100
     */
    public static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int l = n-2;
        int[][] res = new int[l][l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                res[i][j] = getMx(grid, i+1, j+1);
            }
        }
        return res;
    }

    private static int getMx(int[][] grid, int i, int j) {
        int max = grid[i][j];
        for (int k = i-1; k <= i+1; k++) {
            for (int m = j-1; m <= j+1; m++) {
                max = Math.max(max, grid[k][m]);
            }
        }
        return max;
    }

    /**
     * 1476. Subrectangle Queries
     * Medium
     * Topics
     * Companies
     * Hint
     * Implement the class SubrectangleQueries which receives a rows x cols rectangle as a matrix of integers in the constructor and supports two methods:
     *
     * 1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
     *
     * Updates all values with newValue in the subrectangle whose upper left coordinate is (row1,col1) and bottom right coordinate is (row2,col2).
     * 2. getValue(int row, int col)
     *
     * Returns the current value of the coordinate (row,col) from the rectangle.
     *
     *
     * Example 1:
     *
     * Input
     * ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"]
     * [[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
     * Output
     * [null,1,null,5,5,null,10,5]
     * Explanation
     * SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,2,1],[4,3,4],[3,2,1],[1,1,1]]);
     * // The initial rectangle (4x3) looks like:
     * // 1 2 1
     * // 4 3 4
     * // 3 2 1
     * // 1 1 1
     * subrectangleQueries.getValue(0, 2); // return 1
     * subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
     * // After this update the rectangle looks like:
     * // 5 5 5
     * // 5 5 5
     * // 5 5 5
     * // 5 5 5
     * subrectangleQueries.getValue(0, 2); // return 5
     * subrectangleQueries.getValue(3, 1); // return 5
     * subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
     * // After this update the rectangle looks like:
     * // 5   5   5
     * // 5   5   5
     * // 5   5   5
     * // 10  10  10
     * subrectangleQueries.getValue(3, 1); // return 10
     * subrectangleQueries.getValue(0, 2); // return 5
     * Example 2:
     *
     * Input
     * ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue"]
     * [[[[1,1,1],[2,2,2],[3,3,3]]],[0,0],[0,0,2,2,100],[0,0],[2,2],[1,1,2,2,20],[2,2]]
     * Output
     * [null,1,null,100,100,null,20]
     * Explanation
     * SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,1,1],[2,2,2],[3,3,3]]);
     * subrectangleQueries.getValue(0, 0); // return 1
     * subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
     * subrectangleQueries.getValue(0, 0); // return 100
     * subrectangleQueries.getValue(2, 2); // return 100
     * subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
     * subrectangleQueries.getValue(2, 2); // return 20
     *
     *
     * Constraints:
     *
     * There will be at most 500 operations considering both methods: updateSubrectangle and getValue.
     * 1 <= rows, cols <= 100
     * rows == rectangle.length
     * cols == rectangle[i].length
     * 0 <= row1 <= row2 < rows
     * 0 <= col1 <= col2 < cols
     * 1 <= newValue, rectangle[i][j] <= 10^9
     * 0 <= row < rows
     * 0 <= col < cols
     */
    public static class SubrectangleQueries {
        private int[][] rect;

        public SubrectangleQueries(int[][] rectangle) {
            this.rect = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    rect[i][j] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            return rect[row][col];
        }

        /**
         * Your SubrectangleQueries object will be instantiated and called as such:
         * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
         * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
         * int param_2 = obj.getValue(row,col);
         */
    }
}
