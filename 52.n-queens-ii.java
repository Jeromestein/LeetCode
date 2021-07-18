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
        return backtrack(n, 0, 0, 0, 0);
    }

    public int backtrack(int n, int currRow, int columns, int lDiagonals, int rDiagonals) {
        if (currRow == n) {
            return 1;
        }

        int availablePositions = ((1 << n) - 1) & (~(columns | lDiagonals | rDiagonals));
        int cnt = 0;
        while (availablePositions != 0) {
            int currPosition = availablePositions & (-1 * availablePositions);
            availablePositions = availablePositions & (availablePositions - 1);

            cnt += backtrack(n, currRow + 1, columns | currPosition, (lDiagonals | currPosition) << 1,
                    (rDiagonals | currPosition) >> 1);
        }
        return cnt;
    }

}
// @lc code=end
