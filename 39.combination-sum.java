/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();

        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }

        // we will always have two branch
        // 1. just skip, don't consider current idx (idx+1)
        dfs(candidates, target, ans, combine, idx + 1);

        // 2. consider current idx (idx unchange)
        if (target - candidates[idx] >= 0) { // prune
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);

            // reset: remove the last added element
            combine.remove(combine.size() - 1);
            // System.out.println(combine + " " + ans);
        }
    }
}

// @lc code=end
