/*
 * @lc app=leetcode id=922 lang=java
 *
 * [922] Sort Array By Parity II
 */

// @lc code=start

class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i % 2 != nums[i] % 2) {
                for (int j = i + 1; j < n; j += 2) {
                    if (j % 2 != nums[j] % 2) {
                        // swap
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }

        return nums;
    }
}

// @lc code=end
