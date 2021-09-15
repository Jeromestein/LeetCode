/*
 * @lc app=leetcode id=978 lang=java
 *
 * [978] Longest Turbulent Subarray
 */

// @lc code=start

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2)
            return arr.length;

        int sign = 0;
        int cnt = 1;
        int max = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {

                if (sign == -1) {
                    cnt++;
                } else {
                    cnt = 2;
                }
                sign = 1;
            } else if (arr[i - 1] < arr[i]) {

                if (sign == 1) {
                    cnt++;
                } else {
                    cnt = 2;
                }
                sign = -1;
            } else {
                cnt = 1;
            }
            max = Math.max(max, cnt);
        }

        return max;
    }
}

// @lc code=end
