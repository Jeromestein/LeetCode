import java.util.HashMap;

/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        // return the total number of continuous subarrays
        // whose sum equals to k.

        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        int pre = 0;
        int cnt = 0;
        prefixMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (prefixMap.containsKey(pre - k) == true) {
                cnt += prefixMap.get(pre - k);
            }
            prefixMap.put(pre, prefixMap.getOrDefault(pre, 0) + 1);
        }
        return cnt;

    }
}
// @lc code=end
