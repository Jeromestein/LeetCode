import java.util.ArrayList;
import java.util.List;

import org.graalvm.compiler.asm.amd64.AMD64Assembler.AvxVectorLen;

/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    public int totalNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        backtrack(n, 0, 0, 0, 0, new int[n], res, new ArrayList<>());
        return res.size();
    }

    public void backtrack(int n, int currRow, int columns, int lDiagonals, int rDiagonals, int[] queens,
            List<List<String>> res, List<String> temp) {
        if (currRow == n) {
            res.add(new ArrayList<>(temp));
            return;
        }

        int availablePositions = ((1 << n) - 1) & (~(columns | lDiagonals | rDiagonals));
        while (availablePositions != 0) {
            int currPosition = availablePositions & (-1 * availablePositions);
            queens[currRow] = Integer.bitCount(currPosition - 1);

            availablePositions = availablePositions & (availablePositions - 1);

            temp.add(bulidStr(n, queens[currRow]));

            backtrack(n, currRow + 1, columns | currPosition, (lDiagonals | currPosition) << 1,
                    (rDiagonals | currPosition) >> 1, queens, res, temp);
        }

    }

    public String bulidStr(int n, int Q_bit) {
        char[] str = new char[n];
        for (int i = 0; i < str.length; i++) {
            if (str.length - 1 - i == Q_bit)
                str[i] = 'Q';
            else
                str[i] = '.';
        }

        return String.valueOf(str);
    }
}
// @lc code=end
