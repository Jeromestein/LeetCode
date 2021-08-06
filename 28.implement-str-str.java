/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int left = 0, right = 0;
        int n = haystack.length(), m = needle.length();

        while (left < n - m + 1) {
            right = left;

            while (haystack.charAt(right) == needle.charAt(right - left)) {
                if (right - left == m - 1) {
                    return left;
                }

                right++;
            }

            left++;
        }

        return -1;
    }
}
// @lc code=end
