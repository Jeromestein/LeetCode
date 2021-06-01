/*
 * @lc app=leetcode id=852 lang=java
 *
 * [852] Peak Index in a Mountain Array
 */

// @lc code=start
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int pivot = left + (right - left) / 2;
            if (arr[pivot] > arr[pivot + 1]) {
                right = pivot;
            } else {
                left = pivot + 1;
            }
        }
        return left;
        // throw new IllegalArgumentException("No Solution");
    }
}
// @lc code=end
