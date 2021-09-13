/*
 * @lc app=leetcode id=302 lang=java
 *
 * [302] Smallest Rectangle Enclosing Black Pixels
 */

// @lc code=start

class Solution {
    public int minArea(char[][] image, int x, int y) {
        // return the area of the smallest (axis-aligned) rectangle that encloses all
        // black pixels.
        int m = image.length, n = image[0].length;
        int[] rowCnt = new int[m];
        int[] colCnt = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (image[i][j] == '1') {
                    rowCnt[i]++;
                    colCnt[j]++;
                }
            }
        }

        int left = 0, right = n - 1, top = 0, down = m - 1;
        int i = 0;
        while (i < m && rowCnt[i] == 0) {
            i++;
        }
        top = i;
        while (i < m && rowCnt[i] > 0) {
            i++;
        }
        down = i;

        i = 0;
        while (i < n && colCnt[i] == 0) {
            i++;
        }
        left = i;
        while (i < n && colCnt[i] > 0) {
            i++;
        }
        right = i;

        return (right - left) * (down - top);
    }
}
// @lc code=end