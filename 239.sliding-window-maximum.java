/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxSWindow = new int[nums.length - k + 1];
        int left = 0, right = k - 1;
        int maxIdx = getMaxIdx(nums, 0, k - 1);

        while (right < nums.length) {
            if (left <= maxIdx) {
                // max is in the window
                maxSWindow[left] = nums[maxIdx];
                left++;
                right++;

                // prevent java.lang.ArrayIndexOutOfBoundsException
                // from if (nums[right] >= nums[maxIdx])
                if (right == nums.length)
                    break;

                if (nums[right] >= nums[maxIdx])
                    maxIdx = right;
            } else {
                // max is out of the window

                // This 2 if-else make it form 500ms to 3ms !!!
                if (nums[right] >= nums[maxIdx] - 1)
                    maxIdx = right;
                else if (nums[left] >= nums[maxIdx] - 1)
                    maxIdx = left;
                else
                    maxIdx = getMaxIdx(nums, left, right);
            }
        }
        return maxSWindow;
    }

    private int getMaxIdx(int[] nums, int left, int right) {
        int maxVal = nums[left], maxIdx = left;
        for (int i = left + 1; i <= right; i++)
            if (nums[i] >= maxVal) {
                maxVal = nums[i];
                maxIdx = i;
            }
        return maxIdx;
    }

}
// @lc code=end
