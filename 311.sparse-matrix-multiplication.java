/*
 * @lc app=leetcode id=311 lang=java
 *
 * [311] Sparse Matrix Multiplication
 */

// @lc code=start

class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length, k = mat1[0].length, n = mat2[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int l = 0; l < k; l++) {
                    sum += mat1[i][l] * mat2[l][j];
                }
                res[i][j] = sum;
            }
        }

        return res;
    }
}

// @lc code=end
