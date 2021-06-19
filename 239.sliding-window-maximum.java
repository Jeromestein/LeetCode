/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0, end = k - 1;
        int[] maxSlidingWindow = new int[nums.length - k + 1];

        int maxIndex = -1;

        while (end < nums.length) {
            // find the max of subarray
            if (start > maxIndex) {
                // if the old max is out of window
                // then find new max in current window
                int max = Integer.MIN_VALUE;
                for (int i = start; i <= end; i++) {
                    // find the max having biggest index
                    if (max <= nums[i]) {
                        max = nums[i];
                        maxIndex = i;
                    }
                }
                maxSlidingWindow[start] = max;
            } else {
                if (maxSlidingWindow[start - 1] > nums[end]) {
                    maxSlidingWindow[start] = maxSlidingWindow[start - 1];
                } else {
                    maxSlidingWindow[start] = nums[end];
                    maxIndex = end;
                }
            }

            start++;
            end++;
        }

        return maxSlidingWindow;
    }

}
// @lc code=end
