/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        // Could you solve it without loops/recursion?
        // if one number, n is a power of 2,
        // then it will only have one 1 in binary code.
        return n > 0 && (n & (n - 1)) == 0;
    }
}
// @lc code=end
