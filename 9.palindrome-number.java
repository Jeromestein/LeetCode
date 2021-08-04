/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNum = 0;
        while (x > revertedNum) {
            int currDigit = x % 10;
            revertedNum = revertedNum * 10 + currDigit;

            x /= 10;
        }

        return x == revertedNum || x == revertedNum / 10;
    }
}
// @lc code=end
