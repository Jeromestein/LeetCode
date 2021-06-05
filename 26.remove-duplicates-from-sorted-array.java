import jdk.nashorn.api.tree.ForLoopTree;

/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i, j;
        for (i = 0, j = 1; j < nums.length; j++) {
            if (nums[j - 1] != nums[j]) {
                i++;
                nums[i] = nums[j];

            }
        }

        return ++i;
    }

}
// @lc code=end
