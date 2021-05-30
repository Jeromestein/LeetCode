/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lo = 0, hi = matrix[0].length * matrix.length - 1;
        while (lo <= hi) {
            int pivot = lo + (hi - lo) / 2;
            int i = pivot / matrix[0].length;
            int j = pivot % matrix[0].length;
            if (matrix[i][j] == target) {
                return true;
            } else if (target > matrix[i][j]) {
                lo = pivot + 1;
            } else if (target < matrix[i][j]) {
                hi = pivot - 1;
            }
        }

        return false;

    }
}
// @lc code=end
