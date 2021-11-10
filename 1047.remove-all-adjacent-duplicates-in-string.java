/*
 * @lc app=leetcode id=1047 lang=java
 *
 * [1047] Remove All Adjacent Duplicates In String
 */

// @lc code=start

class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int len = 0;
        for (char character : S.toCharArray()) {
            if (len != 0 && character == sb.charAt(len - 1)) {
                sb.deleteCharAt(len - 1);
                len--;
            } else {
                sb.append(character);
                len++;
            }
        }
        return sb.toString();
    }
}
// @lc code=end
