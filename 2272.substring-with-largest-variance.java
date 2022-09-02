/*
 * @lc app=leetcode id=2272 lang=java
 *
 * [2272] Substring With Largest Variance
 */

// @lc code=start
class Solution {
    public int largestVariance(String s) {
        int res = 0;
        // dp[a][b][0] is the freq of a
        // dp[a][b][1] is the max(freqa - freqb) in all substring, minmum is -1
        int[][][] dp = new int[26][26][2];
        for (int i = 0; i < 26; i++)
            for (int j = 0; j < 26; j++)
                dp[i][j][1] = -10000;

        for (int idx = 0; idx < s.length(); idx++) {
            int i = s.charAt(idx) - 'a';
            for (int j = 0; j < 26; j++) {
                if (i != j) {
                    // current ch freq + 1
                    dp[i][j][0] += 1;
                    dp[i][j][1] += 1;

                    // update b&a situation
                    dp[j][i][1] = dp[j][i][0] - 1;
                    if (dp[j][i][0] > 0)
                        dp[j][i][0] -= 1;

                    res = Math.max(dp[j][i][1], res);
                    res = Math.max(dp[i][j][1], res);
                }
            }
        }

        return res;
    }
}

// class Solution {
// public int largestVariance(String s) {
// int[] freq = new int[26];
// for (int i = 0; i < s.length(); i++)
// freq[(int) (s.charAt(i) - 'a')]++;

// int maxVariance = 0;
// for (int a = 0; a < 26; a++) {
// for (int b = 0; b < 26; b++) {
// int remainingA = freq[a];
// int remainingB = freq[b];
// if (a == b || remainingA == 0 || remainingB == 0)
// continue;

// // run Kadanes Algorithm on each possible character pairs (A & B)
// int currBFreq = 0, currAFreq = 0;
// for (int i = 0; i < s.length(); i++) {
// int c = (int) (s.charAt(i) - 'a');

// if (c == b)
// currBFreq++;
// if (c == a) {
// currAFreq++;
// remainingA--;
// }

// if (currAFreq > 0)
// maxVariance = Math.max(maxVariance, currBFreq - currAFreq);

// if (currBFreq < currAFreq && remainingA >= 1) {
// currBFreq = 0;
// currAFreq = 0;
// }
// }
// }
// }

// return maxVariance;
// }
// }
// @lc code=end
