import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3)
            return ans;

        Arrays.sort(nums); // O(nlogn)

        for (int a = 0; a < nums.length - 2; a++) { // O(n^2)
            // if the min >0 then the 3 sum cannot = 0
            if (nums[a] > 0)
                break;

            // the solution set must not contain duplicate triplets.
            if (a > 0 && nums[a] == nums[a - 1])
                continue;

            int b = a + 1, c = nums.length - 1;
            while (b < c) {
                if (nums[a] + nums[b] + nums[c] == 0) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[a], nums[b], nums[c])));

                    b++;
                    c--;
                    // the solution set must not contain duplicate triplets.
                    while (b < c && nums[b] == nums[b - 1])
                        b++;
                    while (b < c && nums[c] == nums[c + 1])
                        c--;
                } else if (nums[a] + nums[b] + nums[c] < 0) {
                    b++;
                } else { // nums[a] + nums[b] + nums[c] > 0
                    c--;
                }
            }
        }

        return ans;
    }
}
// @lc code=end
