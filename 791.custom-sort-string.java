import java.util.Arrays;
import java.util.Map;

/*
 * @lc app=leetcode id=791 lang=java
 *
 * [791] Custom Sort String
 */

// @lc code=start

class Solution {
    public String customSortString(String order, String s) {

        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;

        StringBuilder ans = new StringBuilder();

        // 1. Write all characters that occur in S, in the order of S.
        for (char c : order.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);
            // Setting count[char] to zero
            count[c - 'a'] = 0;
        }

        // 2. Write all remaining characters that don't occur in S.
        // That information is specified by 'count'.
        for (char c = 'a'; c <= 'z'; ++c)
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);

        return ans.toString();
    }
}

// @lc code=end
