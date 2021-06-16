/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
public class Solution {
    private int start, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++) {
            // assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i);
            // assume even length.
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }

    private void extendPalindrome(String s, int left, int right) {
        // 2 pointers
        // left-- and right++
        // expand 2pinter to find the longest palindrome
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (maxLen < right - left - 1) {
            start = left + 1;
            maxLen = right - left - 1;
        }
    }
}
// @lc code=end
