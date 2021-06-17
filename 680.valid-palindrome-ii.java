/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 */

// @lc code=start
class Solution {
    boolean isDeleted = false;

    public boolean validPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    public boolean isPalindrome(final String s, int leftIndex, int rightIndex) {
        while (leftIndex < rightIndex) {
            if (s.charAt(leftIndex) != s.charAt(rightIndex)) {
                if (isDeleted == true) {
                    return false;
                } else {
                    isDeleted = true;
                    return isPalindrome(s, leftIndex + 1, rightIndex) || isPalindrome(s, leftIndex, rightIndex - 1);
                }
            }

            leftIndex++;
            rightIndex--;
        }

        return true;
    }
}
// @lc code=end
