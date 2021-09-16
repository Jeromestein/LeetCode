import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();

        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n, top = 0, down = m;
        int cnt = 0;

        int i = 0, j = 0;

        while (cnt < m * n) {
            // go right
            while (cnt < m * n && j < right) {
                res.add(matrix[i][j]);
                j++;
                cnt++;
            }
            j--;
            i++;
            top++;

            // go down
            while (cnt < m * n && i < down) {
                res.add(matrix[i][j]);
                i++;
                cnt++;
            }
            i--;
            j--;
            right--;

            // go left
            while (cnt < m * n && j >= left) {
                res.add(matrix[i][j]);
                j--;
                cnt++;
            }
            j++;
            i--;
            down--;

            // go up
            while (cnt < m * n && i >= top) {
                res.add(matrix[i][j]);
                i--;
                cnt++;
            }
            i++;
            j++;
            left++;
        }
        return res;
    }
}

// @lc code=end
