/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start

class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            // 1 <= nums.length <= 10^4
            int mid = (lo + hi) / 2;
            if (target > nums[mid]) {
                lo = mid + 1;
            } else if (target < nums[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        if (nums[lo] >= target) {
            return lo;
        } else {
            return lo + 1;
        }
    }
}
// @lc code=end
