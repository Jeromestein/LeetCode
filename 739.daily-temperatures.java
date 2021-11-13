/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // [73,74,75,71,69,72,76,73]
        // 1 1 4 2 1 1 0 0
        int n = temperatures.length;
        int[] res = new int[n];

        int maxT = 30;
        for (int i = n - 1; i >= 0; i--) {
            if (temperatures[i] >= maxT) {
                maxT = temperatures[i];
            } else {
                int skip = 1;
                while (temperatures[i + skip] <= temperatures[i]) {
                    skip += res[i + skip];
                }
                res[i] = skip;
            }

        }
        return res;
    }
}
// @lc code=end
