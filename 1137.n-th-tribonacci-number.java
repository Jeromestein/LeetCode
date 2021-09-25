/*
 * @lc app=leetcode id=1137 lang=java
 *
 * [1137] N-th Tribonacci Number
 */

// @lc code=start

class Solution {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n < 3)
            return 1;

        int[] list = new int[n + 1];
        list[0] = 0;
        list[1] = list[2] = 1;

        for (int i = 3; i <= n; i++) {
            list[i] = list[i - 1] + list[i - 2] + list[i - 3];
        }
        return list[n];
    }
}

// @lc code=end
