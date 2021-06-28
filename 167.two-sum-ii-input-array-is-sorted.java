/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[] { start + 1, end + 1 };
            }
            // The tests are generated such that there is exactly one solution.
            if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[] { 0, 0 };
    }
}
// @lc code=end
