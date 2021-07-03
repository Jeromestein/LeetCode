import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=944 lang=java
 *
 * [944] Delete Columns to Make Sorted
 */

// @lc code=start
class Solution {
    boolean[] notSorted;

    public int minDeletionSize(String[] strs) {
        // use char[][] will make it faster but alse use O(n^2) space
        int row = strs.length, col = strs[0].length();
        // delete the columns that are not sorted lexicographically
        int notSortedCNT = 0;

        for (int x = 0; x < col; x++) {
            for (int y = 0; y < row - 1; y++) {
                if (getChar(strs, x, y) > getChar(strs, x, y + 1)) {
                    notSortedCNT++;
                    break;
                }
            }

        }

        return notSortedCNT;
    }

    public char getChar(String[] strs, int x, int y) {
        return strs[y].charAt(x);
    }
}
// @lc code=end
