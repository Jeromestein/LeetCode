/*
 * @lc app=leetcode id=398 lang=java
 *
 * [398] Random Pick Index
 */

// @lc code=start

// class Solution {

//     Map<Integer, List<Integer>> map;

//     public Solution(int[] nums) {
//         map = new HashMap<>();
//         for (int i = 0; i < nums.length; i++) {
//             map.computeIfAbsent(nums[i], v -> new ArrayList<>()).add(i);
//         }
//     }

//     public int pick(int target) {
//         int n = map.get(target).size();
//         int r = (int) (Math.random() * n);
//         return map.get(target).get(r);
//     }
// }

class Solution {

    private int[] nums;
    private Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    public int pick(int target) {
        int n = this.nums.length;
        int count = 0;
        int idx = 0;
        for (int i = 0; i < n; ++i) {
            // if nums[i] is equal to target, i is a potential candidate
            // which needs to be chosen uniformly at random
            if (this.nums[i] == target) {
                // increment the count of total candidates
                // available to be chosen uniformly at random
                count++;
                // we pick the current number with probability 1 / count (reservoir sampling)
                if (rand.nextInt(count) == 0) {
                    idx = i;
                }
            }
        }
        return idx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
// @lc code=end
