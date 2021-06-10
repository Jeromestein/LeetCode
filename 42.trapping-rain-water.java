/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3)
            return 0;

        int result = 0;
        int leftMax = Integer.MIN_VALUE; // highest bar from left
        int rightMax = Integer.MIN_VALUE; // highest bar from right

        // Key points:
        // all the bars between leftMax and rightMax do not matter
        for (int left = 0, right = height.length - 1; left <= right;) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            // how much can current position trap depends on the shorter bar
            if (leftMax <= rightMax) {
                // DO NOT FORGET to subtract bar height of current position
                result += leftMax - height[left];
                left++;
            } else {
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }
}
// @lc code=end
