/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        // find the index of the smallest value using binary search.
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        // lo/hi is the index of the smallest value
        int rot = lo;
        lo = 0;
        hi = nums.length - 1;

        if (target >= nums[rot] && target <= nums[hi]) {
            lo = rot;
        } else {
            hi = rot;
        }

        // The usual binary search and accounting for rotation.!!!
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
// @lc code=end
