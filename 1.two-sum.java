import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int x = target - nums[i];
            if (map.containsKey(x)) {
                return new int[] { map.get(x), i };
            }
            // hashmap cant store duplicate keys, so detect first than store.
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No Solution");
    }
}
// @lc code=end
