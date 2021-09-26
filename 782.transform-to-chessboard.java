import java.util.Map;

/*
 * @lc app=leetcode id=782 lang=java
 *
 * [782] Transform to Chessboard
 */

// @lc code=start

class Solution {
    public int movesToChessboard(int[][] board) {
        int N = board.length;

        // count[code] = v, where code is an integer
        // that represents the row in *binary*, and v
        // is the number of occurrences of that row
        Map<Integer, Integer> count = new HashMap();
        for (int[] row : board) {
            int code = 0;
            for (int x : row)
                code = 2 * code + x;
            count.put(code, count.getOrDefault(code, 0) + 1);
        }

        int colMoves = analyzeCount(count, N);
        if (colMoves == -1)
            return -1;

        // count[code], as before except with columns
        count = new HashMap();
        for (int c = 0; c < N; ++c) {
            int code = 0;
            for (int r = 0; r < N; ++r)
                code = 2 * code + board[r][c];
            count.put(code, count.getOrDefault(code, 0) + 1);
        }

        int rowMoves = analyzeCount(count, N);
        if (rowMoves == -1)
            return -1;
        else
            return colMoves + rowMoves;
    }

    public int analyzeCount(Map<Integer, Integer> count, int N) {
        // Return -1 if count is not 2
        // Otherwise, return number of swaps required
        if (count.size() != 2)
            return -1;

        // get 2 different states
        List<Integer> states = new ArrayList(count.keySet());
        int states1 = states.get(0), states2 = states.get(1);

        // If lines aren't in the right quantity
        if (!(count.get(states1) == N / 2 && count.get(states2) == (N + 1) / 2)
                && !(count.get(states2) == N / 2 && count.get(states1) == (N + 1) / 2))
            return -1;
        // N-bit 1s
        int Nones = (1 << N) - 1;
        // If lines are opposite, states1 xor states2 == Nones
        if ((states1 ^ states2) != Nones)
            return -1;

        int ones = Integer.bitCount(states1 & Nones);
        int moves = Integer.MAX_VALUE;
        if (N % 2 == 0 || ones * 2 < N) {// zero start
            // 2 <= n <= 30
            // the no. of moves could be the half of 1s in states1 ^ 0xAAAAAAAA
            int m1 = states1 ^ 0xAAAAAAAA;
            // make sure no. of m1 bits is N
            m1 &= Nones;
            moves = Math.min(moves, Integer.bitCount(m1) / 2);
        }

        if (N % 2 == 0 || ones * 2 > N) {// ones start
            // 2 <= n <= 30
            // the no. of moves could be the half of 1s in states1 ^ 0x55555555
            int m2 = states1 ^ 0x55555555;
            // make sure no. of m2 bits is N
            m2 &= Nones;
            moves = Math.min(moves, Integer.bitCount(states1 ^ 0x55555555 & Nones) / 2);
        }

        return moves;
    }
}

// @lc code=end
