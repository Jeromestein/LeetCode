#
# @lc app=leetcode id=3516 lang=python3
#
# [3516] Find Closest Person
#

# @lc code=start


class Solution:
    def findClosest(self, x: int, y: int, z: int) -> int:
        dis1 = abs(z - x)
        dis2 = abs(z - y)

        if dis1 > dis2:
            return 2
        elif dis1 < dis2:
            return 1
        else:
            return 0


# @lc code=end
