/*
 * @lc app=leetcode id=393 lang=java
 *
 * [393] UTF-8 Validation
 */

// @lc code=start
class Solution {
    public boolean validUtf8(int[] data) {
        // 1. start with 0, considered as 1 byte UTF8
        // 2. find 10 to validate the format
        int pre = 0, len = 0;
        for (int i = 0; i < data.length; i++) {
            String b = String.format("%8s", Integer.toBinaryString(data[i])).replaceAll(" ", "0");
            int curr = b.indexOf("0");
            // 1 byte: curr==0
            // 2-4 byte: 2<=first<=4
            if (curr == 0 && len == 0) {
                pre = curr;
            } else if (curr >= 2 && curr <= 4 && len == 0) {
                pre = curr;
                len = curr - 1;
            } else if (curr == 1 && len > 0) {
                pre = curr;
                len--;
            } else {
                return false;
            }

        }

        return pre == 0 || pre == 1 & len == 0;
    }
}
// @lc code=end
