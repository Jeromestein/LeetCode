#
# @lc app=leetcode id=252 lang=python3
#
# [252] Meeting Rooms
#

# @lc code=start

class Solution:
    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        n=len(intervals)
        intervals.sort(key=lambda interval:interval[0])
        for i in range(1,n):
            if intervals[i][0]<intervals[i-1][1]:
                return False

        return True

# @lc code=end

