import java.util.List;

/*
 * @lc app=leetcode id=967 lang=java
 *
 * [967] Numbers With Same Consecutive Differences
 */

// @lc code=start
class Solution {
    List<Integer> res = new ArrayList<>();

    public int[] numsSameConsecDiff(int n, int k) {
        // backtracing
        backtracing(n, k, 0, 0);
        // List<Integer> -> int[]
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void backtracing(int n, int k, int idx, int num) {
        // n>=2
        if (idx == n) {
            res.add(num);
            return;
        }

        if (idx > 0) {
            int lastDigit = num % 10;
            int newDigit1 = lastDigit - k, newDigit2 = lastDigit + k;
            if (newDigit1 < 0 && newDigit2 < 0)
                return;

            if (newDigit1 >= 0 && newDigit1 < 10) {
                int next = num * 10 + newDigit1;
                backtracing(n, k, idx + 1, next);
            }
            if (newDigit1 != newDigit2 && newDigit2 >= 0 && newDigit2 < 10) {
                int next = num * 10 + newDigit2;
                backtracing(n, k, idx + 1, next);
            }
        }
        if (idx == 0) {
            // highest digit should start with 1
            for (int i = 1; i < 10; i++) {
                backtracing(n, k, idx + 1, i);
            }
        }
    }
}
// @lc code=end
