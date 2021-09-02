public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        if (A.length == 0 || m == 0) {
            return 0;
        }

        int n = A.length;
        int[] dp = new int[m + 1];

        // Use rolling array to optimize the space complexity,
        // time complexity is still the same. (but a bit faster)
        // Still 2 for loops,
        // only the second should be inverted order
        // to make sure dp[j - A[i]] will not be updated in advance wrongly.

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= A[i]; j--) {
                dp[j] = Integer.max(dp[j], dp[j - A[i]] + A[i]);
            }
        }
        return dp[m];
    }
}