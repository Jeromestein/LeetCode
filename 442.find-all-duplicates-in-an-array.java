import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=442 lang=java
 *
 * [442] Find All Duplicates in an Array
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        // walk through all the elements
        // use those elements as index visit array
        // first time visit, get opposite number (negtive)
        // and if this number is already negtive, then add it to res
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]);
            nums[idx - 1] *= -1;
            if (nums[idx - 1] > 0)
                res.add(idx);
        }

        return res;
    }
}
// @lc code=end
