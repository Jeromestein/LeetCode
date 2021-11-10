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

        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // int sum = 0;
        // for (int l = 0; l < k; l++) {
        // sum += mat1[i][l] * mat2[l][j];
        // }
        // res[i][j] = sum;
        // }
        // }

        for (int a = 0; a < m; a++) {
            for (int b = 0; b < k; b++) {
                if (mat1[a][b] != 0) {
                    for (int c = 0; c < n; c++) {
                        res[a][c] += mat1[a][b] * mat2[b][c];
                    }
                }
            }
        }

        return res;
    }
}

// @lc code=end
