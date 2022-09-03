/*
 * @lc app=leetcode id=967 lang=java
 *
 * [967] Numbers With Same Consecutive Differences
 */

// @lc code=start
class Solution {
    ArrayList<Integer> res = new ArrayList<>();

    public int[] numsSameConsecDiff(int n, int k) {
        // backtracing

        backtracing(n, k, 0, 0);
        return res.stream().mapToInt(i -> i).toArray();
    }

    private void backtracing(int n, int k, int idx, int num) {
        // n>=2
        if (idx == n) {
            res.add(num);
            return;
        }

        if (idx > 0) {
            // highest digit should start with 1
            int last = num % 10;
            int curr1 = last - k, curr2 = last + k;
            if (curr1 < 0 && curr2 < 0)
                return;

            if (curr1 >= 0 && curr1 < 10) {
                int next = num * 10 + curr1;
                backtracing(n, k, idx + 1, next);
            }
            if (curr1 != curr2 && curr2 >= 0 && curr2 < 10) {
                int next = num * 10 + curr2;
                backtracing(n, k, idx + 1, next);
            }
        }
        if (idx == 0) {
            for (int i = 1; i < 10; i++) {
                backtracing(n, k, idx + 1, i);
            }
        }
    }
}
// @lc code=end
