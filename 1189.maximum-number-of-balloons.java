/*
 * @lc app=leetcode id=1189 lang=java
 *
 * [1189] Maximum Number of Balloons
 */

// @lc code=start
class Solution {
    public int maxNumberOfBalloons(String text) {
        // text consists of lower case English letters only.
        int[] cnt = new int[256];
        // "ballo0n"

        for (int i = 0; i < text.length(); i++) {
            char curr = text.charAt(i);
            cnt[curr]++;
        }

        int res = 10000;
        res = Math.min(res, cnt['a']);
        res = Math.min(res, cnt['b']);
        res = Math.min(res, cnt['l'] / 2);
        res = Math.min(res, cnt['n']);
        res = Math.min(res, cnt['o'] / 2);

        return res;
    }
}
// @lc code=end
