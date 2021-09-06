/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start

class Solution {
    /*
     * Here is an intuition for updating the search space boundaries:
     * 
     * If nums[mid] < nums[hi], nums[mid] or some value before it could be our
     * inflection point. Therefore, let hi = mid, including mid in our new search
     * space.
     * 
     * If nums[mid] > nums[hi], nums[mid] cannot be our inflection point. Candidates
     * are to the right of it. Let lo = mid + 1, exluding the mid from the search
     * space.
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }
}
// @lc code=end
