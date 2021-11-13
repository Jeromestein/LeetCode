/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        // 1 2 3 -> 1 3 2
        // 1 7 6 5 4 3 -> 3 1 4 5 6 7
        // 1 7 6 4 2 5 4 3 2 -> 1 7 6 4 3 2 4 5
        // 7 7 6 5 4 3 -> 3 4 5 6 7 7

        int n = nums.length;
        // 1. find first nums[i]<nums[i+1], from r to l
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            // 2. find first nums[k] greater than nums[i], from r to l
            int k = n - 1;
            while (k >= 0 && nums[i] >= nums[k]) {
                k--;
            }
            // 3. swap nums[i] and nums[k]

            int tmp = nums[i];
            nums[i] = nums[k];
            nums[k] = tmp;
        }

        // 4. revert sums[i+1:...]
        int left = i + 1, right = n - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public void swap(int[] nums, int i, int k) {
        int tmp = nums[i];
        nums[i] = nums[k];
        nums[k] = tmp;
    }
}

// @lc code=end
