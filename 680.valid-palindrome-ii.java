/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 */

// @lc code=start
class Solution {
    boolean deleteFlag = false;

    public boolean validPalindrome(String s) {

        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (deleteFlag == false) {
                    String deleteLeft = removeCharAt(s, left);
                    String deleteRight = removeCharAt(s, right);
                    deleteFlag = true;
                    return validPalindrome(deleteLeft) || validPalindrome(deleteRight);
                } else {
                    return false;
                }
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
}
// @lc code=end
