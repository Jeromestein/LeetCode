/*
 * @lc app=leetcode id=1283 lang=java
 *
 * [1283] Find the Smallest Divisor Given a Threshold
 */

// @lc code=start

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        // Find the smallest divisor such that the result mentioned above is less than
        // or equal to threshold.
        int left = 1, right = 1000000;

        while (left < right) {
            int mid = (left + right) / 2;

            if (getSum(nums, mid) <= threshold) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public int getSum(int[] nums, int mid) {
        int sum = 0;
        for (int n : nums) {
            sum += (n - 1) / mid + 1;
        }
        return sum;
    }
}
// @lc code=end
