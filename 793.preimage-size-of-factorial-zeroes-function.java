/*
 * @lc app=leetcode id=793 lang=java
 *
 * [793] Preimage Size of Factorial Zeroes Function
 */

// @lc code=start

class Solution {
    public int preimageSizeFZF(long K) {
        long lo = K, hi = 10 * K + 1;
        while (lo < hi) {
            long mi = lo + (hi - lo) / 2;
            long zmi = zeta(mi);
            if (zmi == K)
                return 5;
            else if (zmi < K)
                lo = mi + 1;
            else
                hi = mi;
        }
        return 0;
    }

    public long zeta(long x) {
        if (x == 0)
            return 0;
        return x / 5 + zeta(x / 5);
    }
}

// @lc code=end
