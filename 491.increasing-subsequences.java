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
// class Solution {
//     public List<List<Integer>> findSubsequences(int[] nums) {
//         // don't store duplicates
//         Set<List<Integer>> res = new HashSet<>();

//         // Arrays.sort(nums); // don't sort nums[] !!!
//         backtrack(nums, res, new ArrayList<>(), 0);
//         return new ArrayList<>(res);
//     }

//     public void backtrack(int[] nums, Set<List<Integer>> res, List<Integer> temp, int idx) {
//         if (temp.size() > 1) {
//             res.add(new ArrayList<>(temp));
//         }

//         for (int i = idx; i < nums.length; i++) {
//             if (temp.isEmpty() || nums[i] >= temp.get(temp.size() - 1)) {
//                 // if temp is empty or nums[i] >= the last element of temp
//                 temp.add(nums[i]);
//                 backtrack(nums, res, temp, i + 1);
//                 temp.remove(temp.size() - 1);
//             }
//         }
//     }
// }

class Solution {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }

        if (nums[cur] >= last) {
            // choose current element
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }

        if (nums[cur] != last) {
            // not choose current element
            dfs(cur + 1, last, nums);
        }
    }
}
// @lc code=end
