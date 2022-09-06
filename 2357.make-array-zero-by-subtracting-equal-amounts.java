/*
 * @lc app=leetcode id=2357 lang=java
 *
 * [2357] Make Array Zero by Subtracting Equal Amounts
 */

// @lc code=start

class Solution {
    public int minimumOperations(int[] nums) {
        // one pass, use set to store unique?
        Set<Integer> set = new HashSet();
        for (int i : nums)
            if (i != 0)
                set.add(i);
        return set.size();
    }
}

// @lc code=end
