/*
 * @lc app=leetcode id=1209 lang=java
 *
 * [1209] Remove All Adjacent Duplicates in String II
 */

// @lc code=start

class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>();
        // walk through the string
        for (int i = 0; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                counts.push(1);
            } else {
                // If the current character is the same as the one before,
                // increment the count on the top of the stack.
                int incremented = counts.pop() + 1;
                // If the count on the top of the stack equals k,
                // erase last k characters and pop from the stack.
                if (incremented == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    counts.push(incremented);
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end
