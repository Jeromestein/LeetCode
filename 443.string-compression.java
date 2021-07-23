/*
 * @lc app=leetcode id=443 lang=java
 *
 * [443] String Compression
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);

        int charCNT = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                charCNT++;
            } else {
                if (charCNT > 1)
                    sb.append(charCNT);
                sb.append(chars[i]);
                charCNT = 1;
            }
        }
        if (charCNT > 1)
            sb.append(charCNT);

        for (int i = 0; i < chars.length; i++) {
            if (i < sb.length()) {
                chars[i] = sb.charAt(i);
            }
        }

        return sb.length();
    }
}
// @lc code=end
