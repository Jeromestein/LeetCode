/*
 * @lc app=leetcode id=302 lang=java
 *
 * [302] Smallest Rectangle Enclosing Black Pixels
 */

// @lc code=start

// class Solution {
//     public int minArea(char[][] image, int x, int y) {
//         // return the area of the smallest (axis-aligned) rectangle that encloses all
//         // black pixels.
//         int m = image.length, n = image[0].length;
//         int[] rowCnt = new int[m];
//         int[] colCnt = new int[n];

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (image[i][j] == '1') {
//                     rowCnt[i]++;
//                     colCnt[j]++;
//                 }
//             }
//         }

//         int left = 0, right = n - 1, top = 0, down = m - 1;
//         int i = 0;
//         while (i < m && rowCnt[i] == 0) {
//             i++;
//         }
//         top = i;
//         while (i < m && rowCnt[i] > 0) {
//             i++;
//         }
//         down = i;

//         i = 0;
//         while (i < n && colCnt[i] == 0) {
//             i++;
//         }
//         left = i;
//         while (i < n && colCnt[i] > 0) {
//             i++;
//         }
//         right = i;

//         return (right - left) * (down - top);
//     }
// }

public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int left = searchColumns(image, 0, y, 0, m, true);
        int right = searchColumns(image, y + 1, n, 0, m, false);
        int top = searchRows(image, 0, x, left, right, true);
        int bottom = searchRows(image, x + 1, m, left, right, false);
        return (right - left) * (bottom - top);
    }

    private int searchColumns(char[][] image, int i, int j, int top, int bottom, boolean whiteToBlack) {
        while (i != j) {
            int k = top, mid = (i + j) / 2;
            while (k < bottom && image[k][mid] == '0')
                ++k;
            if (k < bottom == whiteToBlack) // k < bottom means the column mid has black pixel
                j = mid; // search the boundary in the smaller half
            else
                i = mid + 1; // search the boundary in the greater half
        }
        return i;
    }

    private int searchRows(char[][] image, int i, int j, int left, int right, boolean whiteToBlack) {
        while (i != j) {
            int k = left, mid = (i + j) / 2;
            while (k < right && image[mid][k] == '0')
                ++k;
            if (k < right == whiteToBlack) // k < right means the row mid has black pixel
                j = mid;
            else
                i = mid + 1;
        }
        return i;
    }
}

// @lc code=end