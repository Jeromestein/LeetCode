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
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}

// @lc code=end
