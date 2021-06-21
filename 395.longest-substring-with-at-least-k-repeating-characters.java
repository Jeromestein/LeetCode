/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                int j = i + 1;
                while (j < s.length() && count[s.charAt(j) - 'a'] < k)
                    j++;
                return Math.max(longestSubstring(s.substring(0, i), k), longestSubstring(s.substring(j), k));
            }
        }

        return s.length();
    }
}
// @lc code=end
