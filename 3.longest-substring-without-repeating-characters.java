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
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        while (end < s.length()) {
            if (map.containsKey(s.charAt(end)) == true) {
                start = end = map.remove(s.charAt(end)) + 1;
                map.clear();

            } else {
                map.put(s.charAt(end), end);
                res = Math.max(res, map.size());
                // System.out.println(map);
                end++;
            }

        }

        return res;
    }
}
// @lc code=end
