/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        // String[] words = s.split(" ");
        // return words[words.length - 1].length();
        int start = 0, end = s.length() - 1;

        // s consists of only English letters and spaces ' '.

        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }

        return end - start;
    }
}
// @lc code=end
