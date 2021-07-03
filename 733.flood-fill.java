import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
// class Solution {
//     int row, col;

//     public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//         if (image[sr][sc] == newColor) {
//             return image;
//         }

//         row = image.length;
//         col = image[0].length;
//         int sColor = image[sr][sc];

//         dfs(image, sr, sc, sColor, newColor);

//         return image;
//     }

//     public void dfs(int[][] image, int x, int y, int sColor, int newColor) {
//         if (0 <= x && x < row && 0 <= y && y < col && image[x][y] == sColor) {
//             image[x][y] = newColor;
//             dfs(image, x + 1, y, sColor, newColor);
//             dfs(image, x - 1, y, sColor, newColor);
//             dfs(image, x, y + 1, sColor, newColor);
//             dfs(image, x, y - 1, sColor, newColor);
//         }
//     }
// }
class Solution {
    int[][] fourDircDelta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }

        int row = image.length, col = image[0].length;
        Queue<int[]> idxQueue = new LinkedList<>();
        idxQueue.add(new int[] { sr, sc });
        int sColor = image[sr][sc];
        image[sr][sc] = newColor;

        while (!idxQueue.isEmpty()) {
            int[] idx = idxQueue.poll();
            int i = idx[0], j = idx[1];

            for (int k = 0; k < 4; k++) {
                int x = i + fourDircDelta[k][0], y = j + fourDircDelta[k][1];
                if (0 <= x && x < row && 0 <= y && y < col && image[x][y] == sColor) {
                    image[x][y] = newColor;
                    idxQueue.add(new int[] { x, y });
                }
            }
        }

        return image;
    }
}
// @lc code=end
