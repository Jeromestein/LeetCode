/*
 * @lc app=leetcode id=2272 lang=java
 *
 * [2272] Substring With Largest Variance
 */

// @lc code=start
class Solution {
    public int largestVariance(String s) {
        int c, i, j;
        int res = 0;
        int[][][] B = new int[26][26][2];
        for (i = 0; i < 26; i++)
            for (j = 0; j < 26; j++)
                B[i][j][1] = -10000;

        for (int idx = 0; idx < s.length(); idx++) {
            c = s.charAt(idx) - 'a';
            for (i = 0; i < 26; i++) {
                if (c != i) {
                    B[c][i][0] += 1;
                    if (B[c][i][1] >= -1)
                        B[c][i][1] += 1;
                    B[i][c][1] = B[i][c][0] - 1;
                    if (B[i][c][0] > 0)
                        B[i][c][0] -= 1;

                    if (B[i][c][1] > res)
                        res = B[i][c][1];
                    if (B[c][i][1] > res)
                        res = B[c][i][1];
                }
            }
        }

        return res;
    }
}
// @lc code=end
