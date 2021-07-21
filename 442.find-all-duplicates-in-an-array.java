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
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // walk through all the elements
            // use those elements as index visit array
            // first time visit, get opposite number (negtive)
            // and if this number is already negtive, then add it to res
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            } else {
                res.add(Math.abs(nums[i]));
            }
        }

        return res;
    }
}
// @lc code=end
