/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 */

// @lc code=start
class Solution {

    // public int findMin(int[] nums) {
    // int res = nums[0];
    // for (int i = 1; i < nums.length; i++) {
    // if (nums[i] < res)
    // return nums[i];
    // }
    // return res;
    // }

    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == nums[hi]) {
                hi--;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return nums[lo];
    }
}
// @lc code=end
