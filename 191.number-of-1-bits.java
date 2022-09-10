/*
 * @lc app=leetcode id=191 lang=java
 *
 * [191] Number of 1 Bits
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            // for any n, n&=(n-1) flips the least-significant 1-bit in n to 0
            n &= (n - 1);
        }
        return sum;
    }
}
// @lc code=end
