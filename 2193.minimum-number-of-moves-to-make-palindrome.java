/*
 * @lc app=leetcode id=2193 lang=java
 *
 * [2193] Minimum Number of Moves to Make Palindrome
 */

// @lc code=start
class Solution {
    public int minMovesToMakePalindrome(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        int res = 0;

        while (sb.length() > 1) {
            char currChar = sb.charAt(0);
            int lastIdx = sb.lastIndexOf(currChar + "");

            if (lastIdx == 0) {
                // only have one, need to move it to the middle
                res += len / 2;
            } else {
                res += len - lastIdx - 1;
                sb.deleteCharAt(lastIdx);
                len--;
            }

            sb.deleteCharAt(0);
            len--;
        }

        return res;
    }
}

// @lc code=end
