import java.util.Arrays;

/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    // 2 Pointers
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                // store the current shortest subarray's length
                minLen = Math.min(minLen, right - left + 1);
                // try to find the shorter subarray
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    // Binary Search
    // elements must be non negtive!!!
    // public int minSubArrayLen(int target, int[] nums) {
    // int minLen = Integer.MAX_VALUE;

    // // size = n+1 for easier calculations
    // // sums[0]=0 : Meaning that it is the sum of first 0 elements
    // // sums[1]=A[0] : Sum of first 1 elements
    // // ans so on...
    // int[] sums = new int[nums.length + 1];
    // sums[0] = 0;
    // for (int i = 1; i < sums.length; i++) {
    // sums[i] = sums[i - 1] + nums[i - 1];
    // }

    // for (int i = 1; i < sums.length; i++) {
    // int bound = Arrays.binarySearch(sums, target + sums[i - 1]);
    // if (bound < 0) {
    // bound = -bound - 1;
    // }
    // if (bound <= nums.length) {
    // minLen = Math.min(minLen, bound - (i - 1));
    // }
    // }

    // return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    // }
}
// @lc code=end
