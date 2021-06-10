/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        // level, bottom, start, end
        int start = 0, end = 0;
        int level, bottom, dis;
        int sumWater = 0, sumheight = 0;

        while (start < height.length) {
            // find a new valley start: decrease
            if (start < height.length - 1 && height[start] > height[start + 1]) {
                end = start;
                sumheight = 0;

                // find valley bottom
                while (end < height.length - 1 && height[end] > height[end + 1]) {
                    end++;
                    sumheight += height[end];
                }
                if (end < height.length - 1 && height[end] < height[end + 1]) {
                    // find valley end
                    while (end < height.length - 1 && height[end] < height[end + 1]) {
                        end++;
                        sumheight += height[end];
                    }
                    // now we get valley start and end
                    sumheight -= height[end];
                    level = Math.min(height[start], height[end]);
                    dis = end - start - 1;
                    // sumWater
                    sumWater += level * dis - sumheight;
                }
            }
            start = Math.max(end, start + 1);
        }
        return sumWater;
    }
}
// @lc code=end
