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
        // 2 pointers
        int start, end;
        start = end = 0;
        // the input is char type, so new boolean[256] is good enough
        // dont need hashmap
        // use O(1) space
        boolean[] isRepeated = new boolean[256];
        int res = 0;
        while (end < s.length()) {
            while (isRepeated[s.charAt(end)] == true) {
                // if it is repeated
                // then move forward start pointer one by one
                // and reset isRepeated as false for the elements that start walks through
                // runs in O(n) time
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
