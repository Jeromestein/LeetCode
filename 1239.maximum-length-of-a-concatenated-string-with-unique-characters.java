import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=1239 lang=java
 *
 * [1239] Maximum Length of a Concatenated String with Unique Characters
 */

// @lc code=start

class Solution {
    int ans = 0;

    public int maxLength(List<String> arr) {
        List<Integer> maskList = new ArrayList<Integer>();
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); ++i) {
                int ch = s.charAt(i) - 'a';
                // if ch already exist in mask, meaning letter repeats, break loop
                if (((mask >> ch) & 1) != 0) {
                    mask = 0;
                    break;
                }
                // add ch to mask
                mask |= 1 << ch;
            }
            if (mask > 0) {
                maskList.add(mask);
            }
        }

        backtrack(maskList, 0, 0);
        return ans;
    }

    public void backtrack(List<Integer> masks, int pos, int mask) {
        if (pos == masks.size()) {
            ans = Math.max(ans, Integer.bitCount(mask));
            return;
        }
        // there is no intersection between mask and masks[pos]
        if ((mask & masks.get(pos)) == 0) {
            // combine those two
            backtrack(masks, pos + 1, mask | masks.get(pos));
        }
        backtrack(masks, pos + 1, mask);
    }
}

// @lc code=end
