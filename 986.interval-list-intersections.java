import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=986 lang=java
 *
 * [986] Interval List Intersections
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || secondList == null)
            return null;

        int i = 0, j = 0;
        int start = 0, end = 0;
        List<int[]> res = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            // get start and end time
            start = Math.max(firstList[i][0], secondList[j][0]);
            end = Math.min(firstList[i][1], secondList[j][1]);
            // closed interval or not?
            if (end >= start) {
                res.add(new int[] { start, end });
            }

            // i++ or j++
            if (end == firstList[i][1]) {
                i++;
            } else {
                j++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end
