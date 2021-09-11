/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */

// @lc code=start

class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > nums[right]) {
                // if left part is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    // target cannot be equal to nums[mid]
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[right]) {
                // if right part is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                /**
                 * duplicates, we know nums[pivot]=nums[left]=nums[right], but != target based
                 * on current information, we can only move left pointer to skip one cell thus
                 * in the worest case, we would have target: 2, and array like 11111111, then
                 * the running time would be O(n)
                 */
                right--;
            }
        }
        if (left == right && nums[left] == target)
            return true;
        else
            return false;
    }
}

// @lc code=end
