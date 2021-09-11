/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // findMin()
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int min = left;

        left = 0;
        right = nums.length - 1;

        // based on min to do first binary search
        if (target >= nums[min] && target <= nums[right]) {
            left = min;
        } else {
            right = min - 1;
        }

        // The usual binary search and accounting for rotation.!!!
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == right && nums[left] == target)
            return left;
        else
            return -1;
    }
}
// @lc code=end
