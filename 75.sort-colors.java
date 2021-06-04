/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        // return nums;
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l >= r)
            return;

        int mid = partition(nums, l, r);
        quickSort(nums, l, mid);
        quickSort(nums, mid + 1, r);
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (l < r && pivot <= nums[r])
                r--;
            nums[l] = nums[r];
            while (l < r && pivot >= nums[l])
                l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }
}
// @lc code=end
