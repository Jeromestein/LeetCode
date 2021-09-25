/*
 * @lc app=leetcode id=1328 lang=java
 *
 * [1328] Break a Palindrome
 */

// @lc code=start

class Solution {
    public String breakPalindrome(String p) {
        int n = p.length();
        if (n == 1)
            return "";

        char[] p1 = p.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            // find first not 'a', also make sure it is not the center
            if (p1[i] != 'a') {
                p1[i] = 'a';
                return String.valueOf(p1);
            }
        }
        // if all are 'a', change last 'a' to 'b'
        p1[n - 1] = 'b';
        return String.valueOf(p1);
    }
}

// @lc code=end
