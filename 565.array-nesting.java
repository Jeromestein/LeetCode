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
        int maxSize = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i;

            // only if nums[j] not in set ann not visited,
            // enter the while loop
            while (!set.contains(nums[j]) && nums[j] >= 0) {
                set.add(nums[j]);
                // nums is a permutation of the numbers in the range [0, n - 1].
                // which means >= 0
                nums[j] *= -1;
                j = nums[j] * -1;

                maxSize = Math.max(maxSize, set.size());
            }
            set.clear();
        }

        return maxSize;
    }
}
// @lc code=end
