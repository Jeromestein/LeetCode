/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();

        // 0 <= strs[i].length <= 200
        int minStrLen = 200;
        for (String string : strs) {
            minStrLen = Math.min(minStrLen, string.length());
        }

        int i, j;
        for (i = 0; i < minStrLen; i++) {
            for (j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[j - 1].charAt(i)) {
                    return res.toString();
                }
            }
            res.append(strs[j - 1].charAt(i));
        }

        return res.toString();
    }
}
// @lc code=end
