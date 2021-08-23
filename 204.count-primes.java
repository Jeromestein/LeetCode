/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

// @lc code=start

class Solution {
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;

                // 0 <= n <= 5 * 10^6
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}

// @lc code=end
