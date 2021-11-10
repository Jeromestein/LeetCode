/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        // only once and 3 times,
        // we can count the 1s in each bit
        for (int i = 0; i < 32; i++) {
            int ones = 0;
            for (int n : nums) {
                ones += ((n >> i) & 1);
            }
            if (ones % 3 != 0) {
                ans = ans + (1 << i);
            }
        }
        return ans;
    }
}
// @lc code=end
