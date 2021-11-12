/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start

// 2^15=4^7*2=16^3*4*2=256*16*4*2

class Solution {
    public double myPow(double x, int n) {
        // FOR N= -2^31
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double A = x;
        // O(logn)
        // A=x^(n/2), if n is even, A*A=x^n, else A*A=x^(n-1)
        for (long i = N; i > 0; i /= 2) {
            // if N is odd
            if ((i % 2) == 1) {
                ans = ans * A;
            }
            A = A * A;
        }
        return ans;
    }
}
// @lc code=end
