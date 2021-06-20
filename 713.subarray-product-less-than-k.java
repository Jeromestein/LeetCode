/*
 * @lc app=leetcode id=713 lang=java
 *
 * [713] Subarray Product Less Than K
 */

// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2)
            return 0;
        int prod = 1, ans = 0, right = 0, left = 0;

        while (right < nums.length) {
            prod *= nums[right];
            while (prod >= k)
                prod /= nums[left++];
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}
// @lc code=end
