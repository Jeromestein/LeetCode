import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4)
            return res;

        Arrays.sort(nums);
        int a = 0, b = 0, c = 0, d = 0;
        for (a = 0; a < nums.length - 3; a++) {
            if (numSum(nums, a, a + 1, a + 2, a + 3) > target)
                break;

            // the solution set must not contain duplicate triplets.
            if (a > 0 && nums[a] == nums[a - 1])
                continue;

            for (b = a + 1; b < nums.length - 2; b++) {
                if (numSum(nums, a, b, b + 1, b + 2) > target)
                    break;
                // the solution set must not contain duplicate triplets.
                if (b > a + 1 && nums[b] == nums[b - 1])
                    continue;

                c = b + 1;
                d = nums.length - 1;
                while (c < d) {
                    if (numSum(nums, a, b, c, d) == target) {
                        res.add(new ArrayList<>(Arrays.asList(nums[a], nums[b], nums[c], nums[d])));
                        c++;
                        d--;
                        // the solution set must not contain duplicate triplets.
                        while (c < d && nums[c] == nums[c - 1])
                            c++;
                        while (c < d && nums[d] == nums[d + 1])
                            d--;

                    } else if (numSum(nums, a, b, c, d) > target) {
                        d--;
                    } else {// numSum(nums, a, b, b + 1, b + 2) < target
                        c++;
                    }
                }
            }
        }

        return res;
    }

    private int numSum(int[] nums, int a, int b, int c, int d) {
        return nums[a] + nums[b] + nums[c] + nums[d];
    }
}
// @lc code=end
