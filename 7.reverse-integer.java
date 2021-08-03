/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int reverseNum = 0;
        int sign = 1;
        // Assume the environment
        // does not allow you to store 64-bit integers (signed or unsigned).
        // -2^31 <= x <= 2^31 - 1
        // -2147483648<= x <= 2147483647
        if (x <= Integer.MIN_VALUE + 6 || x >= Integer.MAX_VALUE - 5) {
            return 0;
        }
        if (x < 0) {
            x *= -1;
            sign = -1;
        }
        while (x != 0) {
            reverseNum *= 10;
            reverseNum += x % 10;
            x /= 10;
            if (x != 0 && reverseNum > Integer.MAX_VALUE / 10) {
                return 0;
            }
        }

        return reverseNum * sign;
    }
}
// @lc code=end
