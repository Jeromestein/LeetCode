import java.util.HashMap;
import java.util.Iterator;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int start, end;
        start = end = 0;
        boolean[] isRepeated = new boolean[256];
        int res = 0;
        while (end < s.length()) {

            while (isRepeated[s.charAt(end)] == true) {
                isRepeated[s.charAt(start)] = false;
                start++;
            }
            isRepeated[s.charAt(end)] = true;
            res = Math.max(res, end - start + 1);
            end++;
        }

        return res;
    }
}
// @lc code=end
