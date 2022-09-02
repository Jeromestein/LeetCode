/*
 * @lc app=leetcode id=2272 lang=java
 *
 * [2272] Substring With Largest Variance
 */

// @lc code=start
// class Solution {
//     public int largestVariance(String s) {
//         int c, i, j;
//         int res = 0;
//         int[][][] dp = new int[26][26][2];
//         for (i = 0; i < 26; i++)
//             for (j = 0; j < 26; j++)
//                 dp[i][j][1] = -10000;

//         for (int idx = 0; idx < s.length(); idx++) {
//             c = s.charAt(idx) - 'a';
//             for (i = 0; i < 26; i++) {
//                 if (c != i) {
//                     dp[c][i][0] += 1;
//                     if (dp[c][i][1] >= -1)
//                         dp[c][i][1] += 1;

//                     dp[i][c][1] = dp[i][c][0] - 1;
//                     if (dp[i][c][0] > 0)
//                         dp[i][c][0] -= 1;

//                     if (dp[i][c][1] > res)
//                         res = dp[i][c][1];
//                     if (dp[c][i][1] > res)
//                         res = dp[c][i][1];
//                 }
//             }
//         }

//         return res;
//     }
// }

class Solution {
    public int largestVariance(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[(int) (s.charAt(i) - 'a')]++;

        int maxVariance = 0;
        for (int a = 0; a < 26; a++) {
            for (int b = 0; b < 26; b++) {
                int remainingA = freq[a];
                int remainingB = freq[b];
                if (a == b || remainingA == 0 || remainingB == 0)
                    continue;

                // run Kadanes Algorithm on each possible character pairs (A & B)
                int currBFreq = 0, currAFreq = 0;
                for (int i = 0; i < s.length(); i++) {
                    int c = (int) (s.charAt(i) - 'a');

                    if (c == b)
                        currBFreq++;
                    if (c == a) {
                        currAFreq++;
                        remainingA--;
                    }

                    if (currAFreq > 0)
                        maxVariance = Math.max(maxVariance, currBFreq - currAFreq);

                    if (currBFreq < currAFreq && remainingA >= 1) {
                        currBFreq = 0;
                        currAFreq = 0;
                    }
                }
            }
        }

        return maxVariance;
    }
}
// @lc code=end
