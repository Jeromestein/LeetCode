import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

// @lc code=start
class Solution {
    public String minRemoveToMakeValid(String s) {
        // use a stack to walk through all the brackets, only store left ones
        // use a set to store all the index should be removed
        Set<Integer> indexesToRemove = new HashSet<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        // Put indexes (redundant left brackets) on the stack into the set.
        while (!stack.isEmpty())
            indexesToRemove.add(stack.pop());

        StringBuilder sb = new StringBuilder();
        // O(n)
        for (int i = 0; i < s.length(); i++) {
            // O(1)
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
// @lc code=end
