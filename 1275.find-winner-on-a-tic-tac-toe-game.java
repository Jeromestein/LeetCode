import java.util.concurrent.ForkJoinPool;

/*
 * @lc app=leetcode id=1275 lang=java
 *
 * [1275] Find Winner on a Tic Tac Toe Game
 */

// @lc code=start
class Solution {
    public String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];

        for (int i = 0; i < moves.length; i++) {
            int x = moves[i][0], y = moves[i][1];
            if (i % 2 == 0) {
                // "A", X
                board[x][y] = 1;
            } else {
                // "B", O
                board[x][y] = -1;
            }
        }

        // chech rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] + board[i][1] + board[i][2] == 3) {
                return "A";
            }
            if (board[i][0] + board[i][1] + board[i][2] == -3) {
                return "B";
            }
        }

        // chech cols
        for (int i = 0; i < 3; i++) {
            if (board[0][i] + board[1][i] + board[2][i] == 3) {
                return "A";
            }
            if (board[0][i] + board[1][i] + board[2][i] == -3) {
                return "B";
            }
        }

        // check diagonals
        if (board[0][0] + board[1][1] + board[2][2] == 3 || board[0][2] + board[1][1] + board[2][0] == 3) {
            return "A";
        }
        if (board[0][0] + board[1][1] + board[2][2] == -3 || board[0][2] + board[1][1] + board[2][0] == -3) {
            return "B";
        }

        if (moves.length == 9) {
            return "Draw";
        } else {
            return "Pending";
        }
    }
}
// @lc code=end
