public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        // 如果背包容量或者物品数量为0，则直接返回
        if (A.length == 0 || m == 0) {
            return 0;
        }
        int n = A.length;
        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            // 滚动数组优化 倒序枚举j
            for (int j = m; j >= A[i]; j--) {
                dp[j] = Integer.max(dp[j], dp[j - A[i]] + A[i]);
            }
        }
        return dp[m];
    }
}