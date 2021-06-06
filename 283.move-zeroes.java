/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // i: zero; j: non zero
        int i = 0, j = 0;
        while (j < nums.length && i < nums.length) {
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            while (j < nums.length && nums[j] == 0) {
                j++;
            }

            if (j >= nums.length || i >= nums.length) {
                break;
            }

            if (j > i) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                if (i < nums.length)
                    i++;
            } else {
                if (j < nums.length)
                    j++;
            }

        }
    }

}
// @lc code=end
