import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        // 1. double for loop, O(n^2), O(1)
        // int n=nums.length, cnt=0;
        // for (int i=0;i<n;i++){
        // int sum=0;
        // for (int j=i;j<n;j++) {
        // sum+=nums[j];
        // if(sum==k)
        // cnt++;
        // }

        // }
        // return cnt;

        // 2. hashmap O(n) O(n)
        Map<Integer, Integer> map = new HashMap<>();
        // if sum[i] - sum[j] = k,
        // the sum of elements lying between indices i and j is k.
        int sum = 0, cnt = 0;
        // of course, there is a 0.
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k) == true) {
                cnt += map.get(sum - k);
            }
            // get the times
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;

    }
}
// @lc code=end
