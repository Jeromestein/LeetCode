/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> monoStack = new Stack<Integer>();
        // from left to right
        for (int i = 0; i < n; ++i) {
            // use mono stack to implement monotone increasing
            // to find the closest column that smaller than i in the left
            while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                monoStack.pop();
            }
            // left[i] is the index of the left column
            left[i] = (monoStack.isEmpty() ? -1 : monoStack.peek());
            monoStack.push(i);
        }

        // from right to left
        monoStack.clear();
        for (int i = n - 1; i >= 0; --i) {
            // use mono stack to implement monotone increasing
            // to find the closest column that smaller than i in the right
            while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                monoStack.pop();
            }
            // right[i] is the index of the right column
            right[i] = (monoStack.isEmpty() ? n : monoStack.peek());
            monoStack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}

// @lc code=end
