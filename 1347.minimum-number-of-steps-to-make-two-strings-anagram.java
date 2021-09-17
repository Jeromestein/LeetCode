/*
 * @lc app=leetcode id=1347 lang=java
 *
 * [1347] Minimum Number of Steps to Make Two Strings Anagram
 */

// @lc code=start

class Solution {
    public int minSteps(String s, String t) {
        // 1 <= s.length <= 50000
        // s.length == t.length
        // s and t contain lower-case English letters only.
        int n = s.length();
        int[] scnt = new int[256];

        // count s
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            scnt[curr]++;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            char curr = t.charAt(i);
            if (scnt[curr] == 0) {
                res++;
            } else {
                scnt[curr]--;
            }
        }

        return res;
    }
}

// @lc code=end
