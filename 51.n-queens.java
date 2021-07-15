import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        // store the location of queens in each row
        // queens[i]=j means in row i the queen is at column j
        int[] queens = new int[n];

        // Arrays.fill(queens,-1); // not necessary
        List<List<String>> results = new ArrayList<>();
        solveNQueens(results, queens, n, 0, 0, 0, 0);
        return results;
    }

    // 0 1 2 3 ... n
    // 0
    // 1
    // 2
    // ...
    // n

    // row means current row
    // columns stores the unavailable columns for current row
    // lDiagonals stores the unavailable left diagonals(right up to left down) for
    // current row
    // lDiagonals stores the unavailable right diagonals(left up to right down) for
    // current row
    public void solveNQueens(List<List<String>> results, int[] queens, int n, int row, int columns, int lDiagonals,
            int rDiagonals) {

        if (row == n) {
            results.add(generateString(queens));
            return;
        }

        // get the available locations for queens
        // ((1 << n) - 1) to get [n-1:0] FFF...FF
        // ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2)) clear high bits as 0
        int availableLocations = ((1 << n) - 1) & (~(columns | lDiagonals | rDiagonals));

        // walk through all the available locations
        while (availableLocations != 0) {
            // get the idx of lowest 1bit in binary
            int position = availableLocations & (-1 * availableLocations);
            // get the idx of lowest 1bit in decimal
            int column = Integer.bitCount(position - 1);
            queens[row] = column;

            // reset the lowest 1bit as 0
            availableLocations = availableLocations & (availableLocations - 1);

            // lDiagonals for next row should do left shift 1 bit due to going down one row
            // rDiagonals for next row should do right shift due bit to going down one row
            solveNQueens(results, queens, n, row + 1, columns | position, (lDiagonals | position) << 1,
                    (rDiagonals | position) >> 1);

            // 官方在这里曾经重置过数组queens的状态，但实际上没这个必要，每次循环上一次的结果都会被覆盖
            // queens[row]=-1;
        }
    }

    public List<String> generateString(int[] queens) {
        List<String> result = new ArrayList<>();
        for (int q : queens) {
            char[] chars = new char[queens.length];
            Arrays.fill(chars, '.');
            chars[q] = 'Q';
            result.add(String.valueOf(chars));
        }
        return result;
    }
}
// @lc code=end
