import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                continue;
            } else {
                digits[i]++;
                return digits;
            }
        }
        digits = new int[n + 1];
        digits[0] = 1;

        return digits;
    }
}
// @lc code=end
