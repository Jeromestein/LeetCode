/*
 * @lc app=leetcode id=696 lang=java
 *
 * [696] Count Binary Substrings
 */

// @lc code=start

class Solution {
    public int countBinarySubstrings(String s) {
        // for example, "00110011" -> {2,2,2,2}, means 2 0s + 2 1s + 2 0s + 2 1s.
        int ans = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }

        return ans + Math.min(prev, cur);
    }
}

// @lc code=end
