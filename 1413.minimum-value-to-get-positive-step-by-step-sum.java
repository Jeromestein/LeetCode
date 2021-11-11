/*
 * @lc app=leetcode id=1413 lang=java
 *
 * [1413] Minimum Value to Get Positive Step by Step Sum
 */

// @lc code=start

class Solution {
    public int minStartValue(int[] nums) {
        // nums [-3, 2, -3, 4, 2]
        // sum -3 -1 -4 0 2
        // 1
        // return -(-4)+1=5

        // O(n) O(1)
        int n = nums.length;
        int sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            min = Math.min(min, sum);
        }

        if (min >= 0) {
            return 1;
        } else {
            return -1 * min + 1;
        }
    }
}

// @lc code=end
