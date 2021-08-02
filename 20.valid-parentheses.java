import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        stack.push(s.charAt(0));

        //
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            boolean isStackEmpty = stack.isEmpty();
            //
            switch (curr) {
            case ')':
                if (isStackEmpty || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
                break;
            //

            case '}':
                if (isStackEmpty || stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
                break;

            case ']':
                if (isStackEmpty || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
                break;

            default:
                stack.push(curr);
                break;
            }
        }

        return stack.size() == 0 ? true : false;
    }
}
// @lc code=end
