/*
 * @lc app=leetcode id=523 lang=java
 *
 * [523] Continuous Subarray Sum
 */

// @lc code=start

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 1 <= k <= 2^31 - 1
            sum %= k;

            Integer prev = map.get(sum);
            if (prev != null) {
                // at least 2
                if (i - prev > 1)
                    return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}

// @lc code=end
