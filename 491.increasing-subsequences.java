import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=491 lang=java
 *
 * [491] Increasing Subsequences
 */

// @lc code=start
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        // don't store duplicates
        Set<List<Integer>> res = new HashSet<>();

        // Arrays.sort(nums); // don't sort nums[] !!!
        backtrack(nums, res, new ArrayList<>(), 0);
        return new ArrayList<>(res);
    }

    public void backtrack(int[] nums, Set<List<Integer>> res, List<Integer> temp, int idx) {
        if (temp.size() > 1) {
            int last = temp.get(temp.size() - 1), secLast = temp.get(temp.size() - 2);
            if (secLast > last) {
                return;
            } else {
                res.add(new ArrayList<>(temp));
            }
        }

        for (int i = idx; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
// @lc code=end
