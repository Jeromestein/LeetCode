/*
 * @lc app=leetcode id=922 lang=java
 *
 * [922] Sort Array By Parity II
 */

// @lc code=start

class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;

        // two pointers, i for even, j for odd
        int i = 0, j = 1;
        while (i < n) {
            if (nums[i] % 2 != 0) {
                while (nums[j] % 2 == 1) {
                    j += 2;
                }

                // swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

            i += 2;
        }

        return nums;
    }
}

// @lc code=end
