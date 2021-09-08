/*
 * @lc app=leetcode id=848 lang=java
 *
 * [848] Shifting Letters
 */

// @lc code=start
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] res = s.toCharArray();
        for (int i = shifts.length - 1; i >= 0; i--) {
            // wrapping around so that 'z' becomes 'a'
            if (i < shifts.length - 1) {
                shifts[i] += shifts[i + 1];
            }
            shifts[i] %= 26;

            if (res[i] + shifts[i] > 'z') {
                int index = res[i] + shifts[i] - 'z' - 1;
                res[i] = (char) ('a' + index);
            } else {
                res[i] += shifts[i];
            }
        }

        return String.valueOf(res);
    }
}
// @lc code=end
