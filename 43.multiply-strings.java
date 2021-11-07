/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 */

// @lc code=start

class Solution {
    public String multiply(String num1, String num2) {
        // for each digits in nums, do the mul with num2
        // 1. from right to left, num1[i]*num2[j]=mul={cin, cout}
        // 2. out[i+j]+=cin, out[i+j-1]+=cout;
        int m = num1.length(), n = num2.length();
        int[] out = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + out[p2];

                out[p1] += sum / 10;
                out[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : out)
            // no leading zeros
            if (sb.length() != 0 || p != 0)
                sb.append(p);

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
// @lc code=end
