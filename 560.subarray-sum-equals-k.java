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
        HashMap<Integer, Integer> prefixFreq = new HashMap<>();
        // we dont need pre[]
        int pre = 0;
        int cnt = 0;
        // of course, there is a 0.
        prefixFreq.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (prefixFreq.containsKey(pre - k) == true) {
                cnt += prefixFreq.get(pre - k);
            }
            // get the times
            prefixFreq.put(pre, prefixFreq.getOrDefault(pre, 0) + 1);
        }
        return cnt;

    }
}
// @lc code=end
