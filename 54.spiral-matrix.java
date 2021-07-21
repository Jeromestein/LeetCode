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
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int row = matrix.length, col = matrix[0].length;
        int num = row * col;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;

        while (num >= 1) {
            for (int i = left; i <= right && num >= 1; i++) {
                res.add(matrix[top][i]);
                num--;
            }
            top++;

            for (int i = top; i <= bottom && num >= 1; i++) {
                res.add(matrix[i][right]);
                num--;
            }
            right--;

            for (int i = right; i >= left && num >= 1; i--) {
                res.add(matrix[bottom][i]);
                num--;
            }
            bottom--;

            for (int i = bottom; i >= top && num >= 1; i--) {
                res.add(matrix[i][left]);
                num--;
            }
            left++;
        }
        return res;
    }
}

// @lc code=end
