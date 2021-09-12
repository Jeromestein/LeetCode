/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (leftDerivative(nums, mid) == 1 && rightDerivative(nums, mid) == -1) {
                return mid;
            } else if (leftDerivative(nums, mid) == 1 && rightDerivative(nums, mid) == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // 1 : +
    // -1: -
    // 0 : 0
    // nums[i] != nums[i + 1]
    // nums[-1] = nums[n] = -∞.
    public int leftDerivative(int[] nums, int index) {
        if (index == 0) {
            return 1;
        }

        if (nums[index] > nums[index - 1]) {
            return 1;
        } else {
            return -1;
        }
    }

    public int rightDerivative(int[] nums, int index) {
        if (index == nums.length - 1) {
            return -1;
        }
        if (nums[index] > nums[index + 1]) {
            return -1;
        } else {
            return 1;
        }
    }
}
// @lc code=end
