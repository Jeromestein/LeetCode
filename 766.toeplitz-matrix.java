/*
 * @lc app=leetcode id=766 lang=java
 *
 * [766] Toeplitz Matrix
 */

// @lc code=start

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        // first n-1 elements in current row are equal to the last n-1 elements in next
        // row
        // O(mn) O(1)
        int m = matrix.length, n = matrix[0].length;
        for (int row = 0; row < m - 1; row++) {
            for (int col = 0; col < n - 1; col++) {
                if (matrix[row][col] != matrix[row + 1][col + 1])
                    return false;
            }
        }

        return true;

    }
}
// @lc code=end
