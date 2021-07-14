import java.util.ArrayList;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> tempList, int n, int k, int start) {
        if (k == 0)
            res.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i <= n; i++) {
                tempList.add(i);
                backtrack(res, tempList, n, k - 1, i + 1);
                // reset
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
// @lc code=end
