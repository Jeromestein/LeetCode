/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxArea = 0;
        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);
            if (height[left] < height[right]) {
                int preleft = height[left];
                while (height[left] <= preleft && left < right) {
                    left++;
                }
            } else {
                int preright = height[right];
                while (height[right] <= preright && left < right) {
                    right--;
                }
            }
        }

        return maxArea;
    }
}
// @lc code=end
