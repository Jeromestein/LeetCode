/*
 * @lc app=leetcode id=848 lang=java
 *
 * [848] Shifting Letters
 */

// @lc code=start
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder res = new StringBuilder();
        for (int i = shifts.length - 1; i >= 0; i--) {
            // wrapping around so that 'z' becomes 'a'
            if (i < shifts.length - 1) {
                shifts[i] += shifts[i + 1];
            }
            shifts[i] %= 26;

            char curr = s.charAt(i);
            if (curr + shifts[i] > 'z') {
                int index = curr + shifts[i] - 'z' - 1;
                curr = (char) ('a' + index);
            } else {
                curr += shifts[i];
            }

            res.insert(0, curr);
        }

        return res.toString();
    }
}
// @lc code=end
