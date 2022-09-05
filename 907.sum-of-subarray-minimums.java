/*
 * @lc app=leetcode id=907 lang=java
 *
 * [907] Sum of Subarray Minimums
 */

// @lc code=start
class Solution {
    int MOD = (int) 1e9 + 7;

    private int getElement(int[] arr, int n, int i) {
        return (i == -1 || i == n) ? Integer.MIN_VALUE : arr[i];
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long ans = 0;
        // Deque is faster than Stack
        Deque<Integer> stack = new LinkedList<>();

        // 2 sentinels: set arr[-1] & arr[n] as MIN_VALUE
        for (int i = -1; i <= n; i++) {
            // Find left closest element, e <= A[i]
            while (!stack.isEmpty() && getElement(arr, n, stack.peek()) > getElement(arr, n, i)) {
                // for each stack.pop(),
                // i is its right boundary and stack.peek() is left boundary.
                int currIdx = stack.pop();
                int left = stack.peek(), right = i;
                // calculate contribution
                ans = (ans + (long) (currIdx - left) * (right - currIdx) * arr[currIdx]) % MOD;
            }
            stack.push(i);
        }

        return (int) ans;
    }
}
// @lc code=end
