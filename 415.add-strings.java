/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 */

// @lc code=start

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;

        int carry = 0;
        while (p1 >= 0 || p2 >= 0) {
            int x1 = 0, x2 = 0;
            if (p1 >= 0)
                x1 = num1.charAt(p1) - '0';
            if (p2 >= 0)
                x2 = num2.charAt(p2) - '0';

            int value = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            res.append(value);
            p1--;
            p2--;
        }

        if (carry != 0)
            res.append(carry);

        return res.reverse().toString();
    }
}

// @lc code=end
