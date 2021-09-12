/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowNum = matrix.length, colNum = matrix[0].length;
        int left = 0, right = rowNum * colNum - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / colNum][mid % colNum];
            if (midVal == target) {
                return true;
            } else if (target > midVal) {
                left = mid + 1;
            } else if (target < midVal) {
                right = mid - 1;
            }
        }

        return false;

    }
}
// @lc code=end
