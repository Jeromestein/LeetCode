/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start

class Solution {
    // Reverse the Whole String and Then Reverse Each Word
    public StringBuilder trimSpaces(String s) {
        // remove leading & trailing spaces
        s = s.trim();

        // reduce multiple spaces to single one
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= s.length() - 1; i++) {
            char curr = s.charAt(i);

            if (curr != ' ')
                sb.append(curr);
            else if (sb.charAt(sb.length() - 1) != ' ')
                sb.append(curr);
        }
        return sb;
    }

    public void reverseString(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            // get end index of the word
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            // reverse the word
            reverseString(sb, start, end - 1);

            // move to the next word
            end++;
            start = end;
        }
    }

    public String reverseWords(String s) {
        // converst string to string builder
        // and trim spaces at the same time
        StringBuilder sb = trimSpaces(s);

        // reverse the whole string
        reverseString(sb, 0, sb.length() - 1);

        // reverse each word
        reverseEachWord(sb);

        return sb.toString();
    }
}

// @lc code=end
