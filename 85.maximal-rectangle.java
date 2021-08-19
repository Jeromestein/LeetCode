import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        int[][] continuousOneCNT = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    // the number of left continuous '1'
                    continuousOneCNT[i][j] = (j == 0 ? 0 : continuousOneCNT[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int j = 0; j < cols; j++) {
            int[] up = new int[rows];
            int[] down = new int[rows];

            Deque<Integer> stack = new LinkedList<Integer>();
            // find its up boundary
            for (int i = 0; i < rows; i++) {
                while (!stack.isEmpty() && continuousOneCNT[stack.peek()][j] >= continuousOneCNT[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            // find its down boundary
            stack.clear();
            for (int i = rows - 1; i >= 0; i--) {
                while (!stack.isEmpty() && continuousOneCNT[stack.peek()][j] >= continuousOneCNT[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? rows : stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < rows; i++) {
                // get height
                int height = down[i] - up[i] - 1;
                int area = height * continuousOneCNT[i][j];
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }
}

// @lc code=end
