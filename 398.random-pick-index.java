/*
 * @lc app=leetcode id=398 lang=java
 *
 * [398] Random Pick Index
 */

// @lc code=start

class Solution {

    Map<Integer, List<Integer>> map;

    public Solution(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], v -> new ArrayList<>()).add(i);
        }
    }

    public int pick(int target) {
        int n = map.get(target).size();
        int r = (int) (Math.random() * n);
        return map.get(target).get(r);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
// @lc code=end
