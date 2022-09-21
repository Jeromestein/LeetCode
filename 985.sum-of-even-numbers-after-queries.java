/*
 * @lc app=leetcode id=985 lang=java
 *
 * [985] Sum of Even Numbers After Queries
 */

// @lc code=start
class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for (int n : nums)
            if (n % 2 == 0)
                sum += n;

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            int val = queries[i][0], index = queries[i][1];
            if (nums[index] % 2 == 0)
                sum -= nums[index];
            nums[index] += val;
            if (nums[index] % 2 == 0)
                sum += nums[index];
            ans[i] = sum;
        }

        return ans;
    }
}
// @lc code=end
