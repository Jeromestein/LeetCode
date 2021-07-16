import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 */

// @lc code=start
public class Solution {
    private int len;
    private char[] charArray;
    private Set<String> validExpressions = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        this.len = s.length();
        this.charArray = s.toCharArray();

        // step 1: walk through all the elements, counting reduntant brackets
        int leftRemove = 0;
        int rightRemove = 0;
        for (int i = 0; i < len; i++) {
            if (charArray[i] == '(') {
                leftRemove++;
            } else if (charArray[i] == ')') {
                if (leftRemove == 0) {
                    rightRemove++;
                }
                if (leftRemove > 0) {
                    // one left bracket and one right bracket make a pair
                    leftRemove--;
                }
            }
        }

        // step 2: backtrack, try all the potential removing operations
        StringBuilder path = new StringBuilder();
        backtrack(0, 0, 0, leftRemove, rightRemove, path);
        return new ArrayList<>(this.validExpressions);
    }

    /**
     * @param index       current index
     * @param leftCount   the no. of visited left brackets
     * @param rightCount  the no. of visited right brackets
     * @param leftRemove  the no. of left brackets should be removed
     * @param rightRemove the no. of right brackets should be removed
     * @param path        one potential result
     */
    private void backtrack(int index, int leftCount, int rightCount, int leftRemove, int rightRemove,
            StringBuilder path) {
        if (index == len) {
            if (leftRemove == 0 && rightRemove == 0) {
                validExpressions.add(path.toString());
            }
            return;
        }

        char character = charArray[index];
        // 1: current character should be removed (not appended to path)
        if (character == '(' && leftRemove > 0) {
            backtrack(index + 1, leftCount, rightCount, leftRemove - 1, rightRemove, path);
        }
        if (character == ')' && rightRemove > 0) {
            backtrack(index + 1, leftCount, rightCount, leftRemove, rightRemove - 1, path);
        }

        // 2: not remove
        path.append(character);
        if (character != '(' && character != ')') {
            // not bracket, just go next
            backtrack(index + 1, leftCount, rightCount, leftRemove, rightRemove, path);
        } else if (character == '(') {
            backtrack(index + 1, leftCount + 1, rightCount, leftRemove, rightRemove, path);
        } else if (rightCount < leftCount) {
            backtrack(index + 1, leftCount, rightCount + 1, leftRemove, rightRemove, path);
        }
        path.deleteCharAt(path.length() - 1);
    }
}
// @lc code=end
