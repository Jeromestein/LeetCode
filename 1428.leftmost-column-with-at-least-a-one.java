/*
 * @lc app=leetcode id=1428 lang=java
 *
 * [1428] Leftmost Column with at Least a One
 */

// @lc code=start
/**
 * // This is the BinaryMatrix's API interface. // You should not implement it,
 * or speculate about its implementation interface BinaryMatrix { public int
 * get(int row, int col) {} public List<Integer> dimensions {} };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0), cols = binaryMatrix.dimensions().get(1);

        int leftmost = cols;
        for (int i = 0; i < rows; i++) {
            int left = 0, right = cols - 1;

            while (left < right) {
                int mid = (left + right) / 2;
                if (binaryMatrix.get(i, mid) == 1) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (binaryMatrix.get(i, left) == 1)
                leftmost = Math.min(leftmost, left);
        }

        if (leftmost == cols)
            return -1;
        else
            return leftmost;
    }
}
// @lc code=end
