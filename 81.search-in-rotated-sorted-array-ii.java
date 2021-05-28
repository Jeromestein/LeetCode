/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // We always get a sorted part and a half part
        // we can check sorted part to decide where to go next
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] == target) {
                return true;
            } else if (nums[left] < nums[pivot]) {
                // left part is sorted
                if (target < nums[left] || target > nums[pivot]) {
                    left = pivot + 1;
                } else {
                    right = pivot - 1;
                }
            } else if (nums[left] > nums[pivot]) {
                // right part is rotated
                if (target < nums[pivot] || target > nums[right]) {
                    right = pivot - 1;
                } else {
                    left = pivot + 1;
                }
            } else {
                // duplicates, we know nums[pivot]=nums[left]=nums[right], but != target
                // based on current information, we can only move left pointer to skip one cell
                // thus in the worest case, we would have target: 2, and array like 11111111,
                // then the running time would be O(n)
                left++;
            }
        }

        return false;
    }
}
// @lc code=end
