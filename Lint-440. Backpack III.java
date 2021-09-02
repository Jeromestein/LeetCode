public class Solution {
    /**
     * @param A: an integer array
     * @param V: an integer array
     * @param m: An integer
     * @return: an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        // write your code here
        int n = A.length;
        // int[][] dp = new int[n + 1][m + 1];

        // for (int i = 1; i <= n; i++) {
        // for (int j = 0; j <= m; j++) {
        // dp[i][j] = dp[i - 1][j];
        // if (j - A[i - 1] >= 0) {
        // dp[i][j] = Math.max(dp[i][j], dp[i][j - A[i - 1]] + V[i - 1]);
        // }
        // }
        // }
        int[] dp = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = A[i]; j <= m; j++) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
            }
        }

        // return dp[n][m];
        return dp[m];
    }
}
