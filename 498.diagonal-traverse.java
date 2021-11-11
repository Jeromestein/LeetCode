/*
 * @lc app=leetcode id=498 lang=java
 *
 * [498] Diagonal Traverse
 */

// @lc code=start

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int m = matrix.length, n = matrix[0].length;

        // Incides that will help us progress through
        // the matrix, one element at a time.
        int row = 0, column = 0;

        // 1 means up, [i, j] -> [i - 1, j + 1]
        // not 1 means down, [i, j] -> [i + 1][j - 1]
        boolean isUP = true;

        // The final result array
        int[] res = new int[m * n];
        int index = 0;

        while (row < m && column < n) {
            res[index++] = matrix[row][column];

            int new_row = row + (isUP ? -1 : 1);
            int new_column = column + (isUP ? 1 : -1);

            if (new_row < 0 || new_row == m || new_column < 0 || new_column == n) {
                if (isUP) {
                    // For an upwards going diagonal having [i, j] as its tail
                    // If [i, j + 1] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i + 1, j] becomes the next head
                    if (column < n - 1) {
                        column += 1;
                    } else {
                        row += 1;
                    }
                } else {
                    // For a downwards going diagonal having [i, j] as its tail
                    // if [i + 1, j] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i, j + 1] becomes the next head
                    if (row < m - 1) {
                        row += 1;
                    } else {
                        column += 1;
                    }
                }

                // Flip the direction
                isUP = !isUP;
            } else {
                row = new_row;
                column = new_column;
            }
        }
        return res;
    }
}
// @lc code=end
