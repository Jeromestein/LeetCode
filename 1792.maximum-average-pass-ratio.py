#
# @lc app=leetcode id=1792 lang=python3
#
# [1792] Maximum Average Pass Ratio
#

# @lc code=start


class Solution:
    def maxAverageRatio(self, classes: List[List[int]], extraStudents: int) -> float:
        # (x+1)/(y+1) - x/y
        # = (y-x)/y(y+1)
        # sort this (*-1 in python heapq)

        increments = []
        # build the heap
        for c in classes:
            x, y = c[0], c[1]
            incre = (y - x) / (y * (y + 1))
            heapq.heappush(increments, (-incre, x, y))

        for i in range(extraStudents):
            _, x, y = heapq.heappop(increments)
            x += 1
            y += 1
            incre = (y - x) / (y * (y + 1))
            heapq.heappush(increments, (-incre, x, y))

        pass_ratio = 0
        n = len(classes)
        for i in increments:
            _, x, y = i
            pass_ratio += x / y / n

        return pass_ratio


# @lc code=end
