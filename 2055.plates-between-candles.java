/*
 * @lc app=leetcode id=2055 lang=java
 *
 * [2055] Plates Between Candles
 */

// @lc code=start
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        // nearest left/right candle index for i
        int[] left = new int[len];
        int[] right = new int[len];
        // preSum[i]: # of candles in [0, i]
        int[] preSum = new int[len];

        int idxL = -1;
        if (s.charAt(0) == '*')
            preSum[0] = 1;
        for (int i = 0; i < len; i++) {
            // if plate, maintain cumulative sum
            if (s.charAt(i) == '*') {
                left[i] = idxL;
                if (i != 0)
                    preSum[i] = preSum[i - 1] + 1;
            } else {
                left[i] = i;
                idxL = i;
                if (i != 0)
                    preSum[i] = preSum[i - 1];
            }
        }

        int idxR = len;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '|')
                idxR = i;
            right[i] = idxR;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            // nearest right candle index for left boundry
            int R = right[queries[i][0]];
            // nearest left candle index for right boundry
            int L = left[queries[i][1]];
            if (L < queries[i][0] || queries[i][1] < R) {
                ans[i] = 0;
                continue;
            }
            ans[i] = preSum[L] - preSum[R];
        }
        return ans;
    }
}
// @lc code=end
