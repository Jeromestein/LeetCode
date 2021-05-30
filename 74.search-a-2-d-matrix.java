/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowNum = matrix.length, colNum = matrix[0].length;
        int lo = 0, hi = rowNum * colNum - 1;
        while (lo <= hi) {
            int pivot = lo + (hi - lo) / 2;
            int pivotVal = matrix[pivot / colNum][pivot % colNum];
            if (pivotVal == target) {
                return true;
            } else if (target > pivotVal) {
                lo = pivot + 1;
            } else if (target < pivotVal) {
                hi = pivot - 1;
            }
        }

        return false;

    }
}
// @lc code=end
