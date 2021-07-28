import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        // HashSet is way faster than LinkedHashSet
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }

        int maxLen = 0, currLen = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                currLen = 1;

                while (numSet.contains(num + currLen)) {
                    currLen++;
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen;
    }
}
// @lc code=end
