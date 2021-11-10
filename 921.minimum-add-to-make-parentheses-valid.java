/*
 * @lc app=leetcode id=921 lang=java
 *
 * [921] Minimum Add to Make Parentheses Valid
 */

// @lc code=start
class Solution {
    public int minAddToMakeValid(String s) {
        int lcnt = 0, rcnt = 0;
        if ("".equals(s)) {
            return 0;
        }

        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                lcnt++;

            } else if (s.charAt(i) == ')') {
                if (lcnt > 0) {
                    lcnt--;
                } else {
                    rcnt++;
                }
            }

        }

        return lcnt + rcnt;
    }
}
// @lc code=end
