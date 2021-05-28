
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

        // lo/hi is the index of the smallest value and the number of places rotated.
        int rot = lo;
        lo = 0;
        hi = nums.length - 1;
        // The usual binary search and accounting for rotation.!!!
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int realmid = (mid + rot) % nums.length;
            if (target == nums[realmid]) {
                return realmid;
            } else if (target < nums[realmid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
// @lc code=end
