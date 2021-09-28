/*
 * @lc app=leetcode id=905 lang=java
 *
 * [905] Sort Array By Parity
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        while (i < n) {
            if (nums[i] % 2 == 0) {
                while (j < i && nums[j] % 2 != 1) {
                    j++;
                }

                // swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

            i++;
        }

        return nums;
    }
}
// @lc code=end
