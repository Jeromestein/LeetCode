/*
 * @lc app=leetcode id=1216 lang=java
 *
 * [1216] Valid Palindrome III
 */

// @lc code=start

class Solution {
    public boolean isValidPalindrome(String s, int k) {
        // dp[i][j]=x means substr(i,j) is x-palindrome
        int dp[][] = new int[s.length()][s.length()];

        // Generate all combinations of `i` and `j` in the correct order.
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                // Case 1: Character at `i` equals character at `j`
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    // Case 2: Character at `i` does not equal character at `j`.
                    // Either delete character at `i` or delete character at `j`
                    // and try to match the two pointers using recursion.
                    // We need to take the minimum of the two results and add 1
                    // representing the cost of deletion.
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        // Return true if the minimum cost to create a palindrome by only deleting the
        // letters is less than or equal to `k`.
        return dp[0][s.length() - 1] <= k;
    }
}

// @lc code=end
