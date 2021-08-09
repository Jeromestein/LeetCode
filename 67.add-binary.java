/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();

        int i = a.length() - 1, j = b.length() - 1;
        int cin = 0;
        while (i >= 0 && j >= 0) {
            int currA = a.charAt(i) - '0', currB = b.charAt(j) - '0';
            int sum = cin + currA + currB;
            cin = sum / 2;
            sum %= 2;

            res.insert(0, sum);
            i--;
            j--;
        }
        while (i >= 0) {
            int currA = a.charAt(i) - '0';
            int sum = cin + currA;
            cin = sum / 2;
            sum %= 2;

            res.insert(0, sum);
            i--;
        }
        while (j >= 0) {
            int currB = b.charAt(j) - '0';
            int sum = cin + currB;
            cin = sum / 2;
            sum %= 2;

            res.insert(0, sum);
            j--;
        }
        if (cin != 0) {
            res.insert(0, cin);
        }

        return res.toString();
    }
}
// @lc code=end
