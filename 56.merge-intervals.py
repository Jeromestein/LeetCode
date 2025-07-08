#
# @lc app=leetcode id=56 lang=python3
#
# [56] Merge Intervals
#

# @lc code=start
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        res=[]
        intervals.sort(key=lambda x: x[0])
        start,end=intervals[0][0], intervals[0][1]
        for interval in intervals:
            if interval[0]>end:
                res.append([start, end])
                # since we sorted, so start <= interval[0]
                start=interval[0]
                end=interval[1]
            else:
                end=max(interval[1],end)

        res.append([start,end])
        return res
# @lc code=end

