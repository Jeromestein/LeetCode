#
# @lc app=leetcode id=986 lang=python3
#
# [986] Interval List Intersections
#

# @lc code=start

class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        # Each list of intervals is pairwise disjoint and in sorted order.
        n,m=len(firstList), len(secondList)
        ptr1, ptr2=0,0
        res=[]
        while ptr1<n and ptr2<m:
            part1, part2=firstList[ptr1],secondList[ptr2]
            start=max(part1[0],part2[0])
            end=min(part1[1],part2[1])
            if start<=end:
                res.append([start,end])

            # Remove the interval with the smallest endpoint
            if part1[1]<part2[1]:
                ptr1+=1
            else:
                ptr2+=1

        return res

# @lc code=end

