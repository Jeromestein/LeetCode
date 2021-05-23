/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (target == nums[pivot]) {
                int start = pivot;
                int end = pivot;
                while (start - 1 >= 0 && nums[start - 1] == target)
                    start--;
                while (end + 1 <= nums.length - 1 && nums[end + 1] == target)
                    end++;
                return new int[] { start, end };
            } else if (target < nums[pivot]) {
                right = pivot - 1;
            } else if (target > nums[pivot]) {
                left = pivot + 1;
            }
        }

        return new int[] { -1, -1 };
    }
}
// @lc code=end
