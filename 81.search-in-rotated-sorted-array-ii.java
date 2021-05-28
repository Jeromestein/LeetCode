/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // findMIn()
        // while (left < right) {
        // int pivot = left + (right - left) / 2;
        // if (nums[pivot] <= nums[right]) {
        // right = pivot;
        // } else {
        // left = pivot + 1;
        // }
        // }
        int rot = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                rot = i;
                break;
            }
        }

        // int rot = left;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            int mid = (pivot + rot) % nums.length;
            if (target == nums[mid]) {
                return true;
            } else if (target < nums[mid]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return false;
    }
}
// @lc code=end
