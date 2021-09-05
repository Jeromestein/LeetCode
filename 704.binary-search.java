
/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // If target exists, then return its index. Otherwise, return -1.
        // if use while (left = right), when n=1, it will skip the loop.
        // so it must be while (left <= right)
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return -1;
    }
}
// @lc code=end
