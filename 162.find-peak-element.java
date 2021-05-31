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
            int pivot = left + (right - left) / 2;
            if (leftDerivative(nums, pivot) == 1 && rightDerivative(nums, pivot) == -1) {
                return pivot;
            } else if (leftDerivative(nums, pivot) == 1 && rightDerivative(nums, pivot) == 1) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        throw new IllegalArgumentException("No Solution");
    }

    // 1 : +
    // -1: -
    // 0 : 0
    public int leftDerivative(int[] nums, int index) {
        if (index == 0) {
            return 1;
        }
        if (nums[index] > nums[index - 1]) {
            return 1;
        } else if (nums[index] < nums[index - 1]) {
            return -1;
        } else if (nums[index] == nums[index - 1]) {
            return 0;
        }
        throw new IllegalArgumentException("No Solution");
    }

    public int rightDerivative(int[] nums, int index) {
        if (index == nums.length - 1) {
            return -1;
        }
        if (nums[index] > nums[index + 1]) {
            return -1;
        } else if (nums[index] < nums[index + 1]) {
            return +1;
        } else if (nums[index] == nums[index + 1]) {
            return 0;
        }
        throw new IllegalArgumentException("No Solution");
    }
}
// @lc code=end
