/*
 * @lc app=leetcode id=917 lang=java
 *
 * [917] Reverse Only Letters
 */

// @lc code=start

class Solution {
    public String reverseOnlyLetters(String s) {
        char[] str = s.toCharArray();

        int left = 0, right = s.length() - 1;

        while (left < right) {
            // All the characters that are not English letters remain in the same position.
            // All the English letters (lowercase or uppercase) should be reversed.
            if (Character.isLetter(str[left]) && Character.isLetter(str[right])) {
                // swap
                char t = str[left];
                str[left] = str[right];
                str[right] = t;

                left++;
                right--;
            }
            while (left < right && !Character.isLetter(str[left])) {
                left++;
            }
            while (left < right && !Character.isLetter(str[right])) {
                right--;
            }

        }

        return String.valueOf(str);
    }
}

// @lc code=end
