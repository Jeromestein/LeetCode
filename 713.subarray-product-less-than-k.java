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
        int production = 1, ans = 0, right = 0, left = 0;

        while (right < nums.length) {
            production *= nums[right];
            while (production >= k) {
                // move left forward to keep production < k
                production /= nums[left];
                left++;
            }

            // In short, "right - left + 1" gives
            // the number of new sub-arrays generated
            // upon adding a new element in the array.
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}
// @lc code=end
