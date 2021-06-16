import java.util.ArrayList;
import java.util.Set;

/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int left = 0;
        int right = len - 1;
        while (left < right) {
            char leftChar = arr[left];
            char rightChar = arr[right];

            if (isVowels(leftChar) == false) {
                left++;
            } else if (isVowels(rightChar) == false) {
                right--;
            } else {
                // leftChar and rightChar are vowel at same time
                // swap
                arr[left] = rightChar;
                arr[right] = leftChar;
                left++;
                right--;
            }
        }

        String res = String.valueOf(arr);
        return res;
    }

    private boolean isVowels(char x) {
        return (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u' || x == 'A' || x == 'E' || x == 'I' || x == 'O'
                || x == 'U');
    }
}
// @lc code=end
