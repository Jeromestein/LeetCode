/*
 * @lc app=leetcode id=302 lang=java
 *
 * [302] Smallest Rectangle Enclosing Black Pixels
 */

// @lc code=start

class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        // binary search [0, y) to find left
        int left = searchColumns(image, 0, y, 0, m, true);
        // binary search [y+1, n) to find right
        int right = searchColumns(image, y + 1, n, 0, m, false);
        // binary search [0, x) to find top
        int top = searchRows(image, 0, x, left, right, true);
        // binary search [x+1, m) to find bottom
        int bottom = searchRows(image, x + 1, m, left, right, false);
        return (right - left) * (bottom - top);
    }

    private int searchColumns(char[][] image, int i, int j, int top, int bottom, boolean whiteToBlack) {
        while (i != j) {
            int mid = (i + j) / 2;
            // frome top to bottom, stop when image[k][mid] == '1'
            int k = top;
            while (k < bottom && image[k][mid] == '0')
                k++;
            if (k < bottom == whiteToBlack) // k < bottom == true means the column mid has black pixel
                j = mid; // search the boundary in the smaller half
            else
                i = mid + 1; // search the boundary in the greater half
        }
        return i;
    }

    private int searchRows(char[][] image, int i, int j, int left, int right, boolean whiteToBlack) {
        while (i != j) {
            int mid = (i + j) / 2;
            // frome left to right, stop when image[mid][k] == '1'
            int k = left;
            while (k < right && image[mid][k] == '0')
                k++;
            if (k < right == whiteToBlack) // k < right == true means the row mid has black pixel
                j = mid;
            else
                i = mid + 1;
        }
        return i;
    }
}

// @lc code=end
