/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start

/*
Here is an intuition for updating the search space boundaries:

If nums[mid] < nums[hi], 
nums[mid] or some value before it could be our inflection point. 
Therefore, let hi = mid, 
including mid in our new search space.

If nums[mid] > nums[hi], 
nums[mid] cannot be our inflection point. 
Candidates are to the right of it. 
Let lo = mid + 1, exluding the mid from the search space.
*/
class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return nums[lo];
    }
}
// @lc code=end
