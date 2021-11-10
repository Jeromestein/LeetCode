/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start

// class Solution {
//     public int numTrees(int n) {
//         // use long to avoid overflow
//         long C = 1;
//         for (int i = 0; i < n; ++i) {
//             C = C * 2 * (2 * i + 1) / (i + 2);
//         }
//         return (int) C;
//     }
// }

class Solution {
    public int numTrees(int n) {
        // 1. n: [1, 19]
        // backtrace, preorder ?
        // recurrsive, numTress(int n)=numTressLeft+numTressRight
        // x, i, left [1,i-1], right[i,x]
        // numTress(x)= numTress[i-1]*numTress[x-i]
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        // x is the no. of nodes
        for (int x = 2; x <= n; x++) {
            // i is the index of root
            for (int i = 1; i <= x; i++) {
                dp[x] += (dp[i - 1] * dp[x - i]);
            }
        }

        return dp[n];

    }
}

// @lc code=end
