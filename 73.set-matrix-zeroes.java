/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start
class Solution {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;

        // use setRow0Zero/setCol0Zero to find
        // if we should set first row/first col as 0
        boolean setRow0Zero = false, setCol0Zero = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        // if a element in first row is 0,
                        // we should set first row as 0
                        setRow0Zero = true;
                    }
                    if (j == 0) {
                        // if a element in first col is 0,
                        // we should set first col as 0
                        setCol0Zero = true;
                    }
                    // matrix[0][j] means we should set col j as 0
                    // matrix[i][0] means we should set row i as 0
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
            // set first row as 0
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }

        if (setCol0Zero) {
            // set first col as 0
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
// @lc code=end
