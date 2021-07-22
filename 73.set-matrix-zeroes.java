/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;

        boolean setRow0Zero = false, setCol0Zero = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        setRow0Zero = true;
                    }
                    if (j == 0) {
                        setCol0Zero = true;
                    }
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        for (int i = row - 1; i > 0; i--) {
            for (int j = col - 1; j > 0; j--) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (setRow0Zero) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }

        if (setCol0Zero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
// @lc code=end
