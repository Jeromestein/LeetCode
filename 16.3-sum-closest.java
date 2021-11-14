/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length, diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int a = 0; a < n; a++) {
            int b = a + 1, c = n - 1;
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }

                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    b++;
                } else if (sum > target) {
                    c--;
                }
            }

        }

        return target - diff;
    }
}

// @lc code=end
