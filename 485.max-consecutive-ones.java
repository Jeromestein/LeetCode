/*
 * @lc app=leetcode id=485 lang=java
 *
 * [485] Max Consecutive Ones
 */

// @lc code=start

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, curr = 0;
        for (int n : nums) {
            // a binary array
            if (n == 0) {
                curr = 0;
            } else {
                curr++;
                max = Math.max(max, curr);
            }
        }

        return max;
    }
}
// @lc code=end
