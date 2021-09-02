import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=565 lang=java
 *
 * [565] Array Nesting
 */

// @lc code=start
class Solution {
    public int arrayNesting(int[] nums) {
        Set<Integer> set = new HashSet<>();
        boolean[] isVisited = new boolean[nums.length];
        int maxSize = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (!set.contains(nums[j]) && !isVisited[j]) {
                set.add(nums[j]);
                isVisited[j] = true;
                j = nums[j];

                maxSize = Math.max(maxSize, set.size());
            }
            set.clear();
        }

        return maxSize;
    }
}
// @lc code=end
