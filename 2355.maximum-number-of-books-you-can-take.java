/*
 * @lc app=leetcode id=2355 lang=java
 *
 * [2355] Maximum Number of Books You Can Take
 */

// @lc code=start
class Solution {
    // backtracing? no, length is too big
    // dp...

    // find the painpoints
    /*
     * 0, 1, 2, 3, 4, 5, 6, 7, 8
     * arr: 8, 2, 4, 7, 3, 5, 10, 9, 4
     * painpoint: -1,-1, 1, 2,-1, 4, 5, 5, -1
     * dp: 8, 3, 7
     * // dp[i] means the max number of books you can take if you can only take
     * books from shelves [0, i]
     * // and you must take books from shelf i.
     * // for dp[0] : 8 no painpoint
     * // for dp[1] : 2 + 1 = 3; no painpoint
     * // for dp[2] : 4 + 2(not 3) + ... = 4 + dp[1] = 7, painpoint index 1
     * // for dp[3] : 7 + 4(not 6) + ... = 7 + dp[2] = 14, painpoint index 2
     * // for dp[4] : 3 + 2 + 1 = 6; // no Painpoint
     * // for dp[5] : 5 + 3(not 4) + ... = 5 + dp[4] = 11, painpoint index 4
     * // for dp[6] : 10 + 5(not 9) + ... = 10 + dp[5] = 21, painpoint index 5
     * // for dp[7] : 9 + 8 + 5(not 7) + ... = 9 + 8 + dp[5] = 28, painpoint index 5
     * // for dp[8] : 4 + 3 + 2 + 1 = 10;
     * 
     * // painPoints[i] is j, that j is the index of nearst left element
     * // that i - j < books[i] - books[j]
     */
    public long maximumBooks(int[] books) {
        int n = books.length;
        int[] painPoints = new int[n];
        Arrays.fill(painPoints, -1);

        // similar to nextGreater Monotonic Stack approach.
        Stack<Integer> stack = new Stack<>();
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && stack.peek() - j < books[stack.peek()] - books[j]) {
                painPoints[stack.pop()] = j;
            }
            stack.push(j);
        }

        // dp[i] means the max number of books you can take if you can only take books
        // from shelves [0, i]
        // and you must take books from shelf i.
        long[] dp = new long[n];
        dp[0] = books[0];
        for (int i = 1; i < n; i++) {
            if (painPoints[i] == -1) {
                // 1 + 2 + ... + books[i]
                dp[i] = cumSum(books[i]);
                // books[i]-i + books[i]-i+1 + ... + books[i]
                if (books[i] - i - 1 > 0) {
                    dp[i] -= cumSum(books[i] - i - 1);
                }
            } else {
                dp[i] = dp[painPoints[i]] + cumSum(books[i]) - cumSum(books[i] - i + painPoints[i]);
            }
        }

        long res = 0;
        for (int i = 0; i < n; i++)
            res = Math.max(res, dp[i]);
        return res;
    }

    // return the sum of 1 + 2 + 3 + ..... + n-1 + n;
    private long cumSum(int n) {
        return ((long) n + 1) * n / 2;
    }
}
// @lc code=end
