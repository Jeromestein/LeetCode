/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return -1;
        }
        return quickSort(nums, 0, nums.length - 1, k - 1);

    }

    public int quickSort(int[] nums, int start, int end, int k) {
        int left = start;
        int right = end;
        if (left >= right) {
            return nums[k];
        }
        int pivot = nums[(left + right) / 2];
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }

        if (k <= right) {
            return quickSort(nums, start, right, k);
        } else if (k >= left) {
            return quickSort(nums, left, end, k);
        } else {
            return nums[k];
        }

    }
}
// @lc code=end
