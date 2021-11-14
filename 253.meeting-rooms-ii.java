/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // Min heap, pq, defaultly increasing order
        PriorityQueue<Integer> allocator = new PriorityQueue<>();

        // Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Add the first meeting, finishing time
        allocator.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            // If the current interval starts after the min ending time
            // update the ending time
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            // 1. no more room, update the ending time, add current interval
            // 2. one more room, add current interval
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }
}
// @lc code=end
