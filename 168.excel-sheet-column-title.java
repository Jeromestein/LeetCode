/*
 * @lc app=leetcode id=168 lang=java
 *
 * [168] Excel Sheet Column Title
 */

// @lc code=start
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();

        while (columnNumber != 0) {
            if (columnNumber % 26 != 0) {
                char currDigit = (char) (columnNumber % 26 + 'A' - 1);
                columnNumber /= 26;
                res.insert(0, currDigit);
            } else {
                char currDigit = 'Z';
                res.insert(0, currDigit);
                columnNumber /= 26;
                columnNumber--;
            }

        }

        return res.toString();
    }
}
// @lc code=end
