/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        char[] sChar = s.toCharArray(), tChar = t.toCharArray();
        int[] need = new int[256];
        for (int i = 0; i < tChar.length; i++) {
            need[tChar[i]]++;
        }
        int needCharCNT = tChar.length;
        int left = 0, right = 0;
        int ansL = -1, ansR = -1, len = Integer.MAX_VALUE;
        while (right < sChar.length) {

            need[sChar[right]]--;
            if (need[sChar[right]] >= 0) {
                needCharCNT--;
            }

            // try to make this substring shorter in this loop
            while (needCharCNT == 0) {
                if (right - left < len) {
                    // save the current shortest substring
                    ansL = left;
                    ansR = right;
                    len = ansR - ansL;
                }

                // restore before left+1
                need[sChar[left]]++;
                if (need[sChar[left]] > 0) {
                    needCharCNT++;
                }
                left++;
            }

            right++;
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }
}
// @lc code=end
