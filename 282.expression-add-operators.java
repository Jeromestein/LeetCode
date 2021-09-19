import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=282 lang=java
 *
 * [282] Expression Add Operators
 */

// @lc code=start

// 1. Note that a number can contain multiple digits.

// 2. Since the question asks us to find all of the valid expressions, we need a
// way to iterate over all of them. (Hint: Recursion!)

// 3. We can keep track of the expression string and evaluate it at the very end.
// But that would take a lot of time. Can we keep track of the expression's
// value as well so as to avoid the evaluation at the very end of recursion?

// 4. Think carefully about the multiply operator. It has a higher precedence than
// the addition and subtraction operators.
// 1 + 2 = 3 
// 1 + 2 - 4 --> 3 - 4 --> -1
// 1 + 2 - 4 * 12 --> -1 * 12 --> -12 (WRONG!)
// 1 + 2 - 4 * 12 --> -1 - (-4) + (-4 * 12) --> 3 + (-48) --> -45 (CORRECT!)..

// 5. We simply need to keep track of the last operand in our expression and
// reverse it's effect on the expression's value while considering the multiply
// operator.

class Solution {
    public ArrayList<String> answer;
    public String digits;
    public long target;

    /**
     * 
     * @param index
     * @param previousOperand
     * @param currentOperand
     * @param value
     * @param ops
     */
    public void dfs(int index, long previousOperand, long currentOperand, long value, ArrayList<String> ops) {
        String nums = this.digits;

        // Done processing all the digits in num
        if (index == nums.length()) {
            // If the final value == target expected AND
            // no operand is left unprocessed
            if (value == this.target && currentOperand == 0) {
                StringBuilder sb = new StringBuilder();
                ops.subList(1, ops.size()).forEach(v -> sb.append(v));
                this.answer.add(sb.toString());
            }
            return;
        }

        // Extending the current operand by one digit
        currentOperand = currentOperand * 10 + nums.charAt(index) - '0';
        String current_val_rep = Long.toString(currentOperand);

        // To avoid cases where we have 1 + 05 or 1 * 05 since 05 won't be a
        // valid operand. Hence this check
        if (currentOperand > 0) {
            // NO OP recursion
            dfs(index + 1, previousOperand, currentOperand, value, ops);
        }

        // ADDITION
        ops.add("+");
        ops.add(current_val_rep);
        dfs(index + 1, currentOperand, 0, value + currentOperand, ops);
        ops.remove(ops.size() - 1);
        ops.remove(ops.size() - 1);

        if (ops.size() > 0) {
            // SUBTRACTION
            ops.add("-");
            ops.add(current_val_rep);
            dfs(index + 1, -currentOperand, 0, value - currentOperand, ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);

            // MULTIPLICATION
            ops.add("*");
            ops.add(current_val_rep);
            dfs(index + 1, currentOperand * previousOperand, 0,
                    value - previousOperand + (currentOperand * previousOperand), ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);
        }
    }

    public List<String> addOperators(String num, int target) {
        if (num.length() == 0) {
            return new ArrayList<String>();
        }

        this.target = target;
        this.digits = num;
        this.answer = new ArrayList<String>();
        this.dfs(0, 0, 0, 0, new ArrayList<String>());
        return this.answer;
    }
}

// @lc code=end
