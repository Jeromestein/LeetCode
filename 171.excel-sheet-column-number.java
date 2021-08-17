/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 */

// @lc code=start
class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char currDigit = columnTitle.charAt(i);

            res *= 26;
            res += currDigit - 'A' + 1;
        }

        return res;
    }
}
// @lc code=end
