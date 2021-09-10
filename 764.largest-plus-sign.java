/*
 * @lc app=leetcode id=764 lang=java
 *
 * [764] Largest Plus Sign
 */

// @lc code=start

class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> bannedSet = new HashSet();
        int[][] dp = new int[N][N];

        for (int[] mine : mines) {
            System.out.println(mine[0]);
            System.out.println(mine[1]);
            bannedSet.add(mine[0] * N + mine[1]);
        }
        System.out.println(bannedSet);
        int ans = 0, count;

        for (int row = 0; row < N; ++row) {
            count = 0;
            for (int col = 0; col < N; ++col) {
                count = bannedSet.contains(row * N + col) ? 0 : count + 1;
                dp[row][col] = count;
            }

            count = 0;
            for (int col = N - 1; col >= 0; --col) {
                count = bannedSet.contains(row * N + col) ? 0 : count + 1;
                dp[row][col] = Math.min(dp[row][col], count);
            }
        }

        for (int col = 0; col < N; ++col) {
            count = 0;
            for (int row = 0; row < N; ++row) {
                count = bannedSet.contains(row * N + col) ? 0 : count + 1;
                dp[row][col] = Math.min(dp[row][col], count);
            }

            count = 0;
            for (int row = N - 1; row >= 0; --row) {
                count = bannedSet.contains(row * N + col) ? 0 : count + 1;
                dp[row][col] = Math.min(dp[row][col], count);
                ans = Math.max(ans, dp[row][col]);
            }
        }

        return ans;
    }
}

// @lc code=end
