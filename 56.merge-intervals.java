import java.awt.List;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        // if intervals is having less than 1 element, return intervals
        if (intervals.length <= 1) {
            return intervals;
        }

        // Arrays.sort() with lambda expression
        // return a[0]-b[0];
        // sort the intervals based on 1st index value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // make two variables start and end
        int start = intervals[0][0];
        int end = intervals[0][1];

        List<int[]> result = new ArrayList<>();

        // run a loop and compare intervals[i][0] with end
        for (int[] interval : intervals) {
            // if it overlaps then update end
            if (interval[0] <= end) {
                end = Math.max(interval[1], end);
            } // else add this interval in result
            else {
                result.add(new int[] { start, end });
                start = interval[0];
                end = interval[1];
            }
        }
        result.add(new int[] { start, end });

        return result.toArray(new int[result.size()][]);
    }

    // public int[][] merge(int[][] intervals) {
    // int nMerged = 1;
    // for (int i = 0; i < intervals.length; i++) {
    // int interval[] = intervals[i];
    // int i0 = interval[0];
    // int i1 = interval[1];
    // int nRemain = 0;
    // for (int j = 0; j < nMerged; j++) {
    // int candidate[] = intervals[j];
    // int m0 = candidate[0];
    // int m1 = candidate[1];
    // if (m1 < i0) {
    // // m0,m1 lower than i0,i1 - retain m0,m1
    // nRemain++;
    // } else if (i1 < m0) {
    // // i0,i1 lower than m0,m1 - retain i0,i1, continue with m0,m1
    // intervals[nRemain++] = interval;
    // interval = candidate;
    // } else {
    // if (m0 < i0)
    // interval[0] = i0 = m0;
    // if (m1 > i1)
    // interval[1] = i1 = m1;
    // }
    // }
    // intervals[nRemain++] = interval;
    // nMerged = nRemain;
    // }
    // int result[][] = new int[nMerged][];
    // for (int i = 0; i < result.length; i++) {
    // result[i] = intervals[i];
    // }
    // return result;
    // }
}
// @lc code=end
