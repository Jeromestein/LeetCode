import java.lang.reflect.Array;

/*
 * @lc app=leetcode id=252 lang=java
 *
 * [252] Meeting Rooms
 */

// @lc code=start

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }

        }

        return true;
    }
}
// @lc code=end
