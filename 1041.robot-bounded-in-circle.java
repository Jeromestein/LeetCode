/*
 * @lc app=leetcode id=1041 lang=java
 *
 * [1041] Robot Bounded In Circle
 */

// @lc code=start

class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        // Initial position is in the center
        int x = 0, y = 0;
        // facing north
        int idx = 0;

        for (char i : instructions.toCharArray()) {
            switch (i) {
                case 'L':
                    // change direction, go left
                    idx = (idx + 3) % 4;
                    break;
                case 'R':
                    // change direction, go right
                    idx = (idx + 1) % 4;
                    break;
                case 'G':
                    // one step
                    x += dirs[idx][0];
                    y += dirs[idx][1];
                    break;
            }

        }

        // after one cycle:
        // robot returns into initial position
        // or robot doesn't face north
        return (x == 0 && y == 0) || (idx != 0);
    }
}

// @lc code=end
