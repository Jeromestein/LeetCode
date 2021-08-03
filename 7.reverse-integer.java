/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int reverseNum = 0;
        // Assume the environment
        // does not allow you to store 64-bit integers (signed or unsigned).
        // -2^31 <= x <= 2^31 - 1
        // -2147483648<= x <= 2147483647

        while (x != 0) {
            if (reverseNum > Integer.MAX_VALUE / 10 || reverseNum < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int currDigit = x % 10;
            reverseNum = reverseNum * 10 + currDigit;

            x /= 10;
        }

        return reverseNum;
    }
}
// @lc code=end
