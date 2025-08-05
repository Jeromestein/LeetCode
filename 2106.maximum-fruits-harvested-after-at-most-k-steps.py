#
# @lc app=leetcode id=2106 lang=python3
#
# [2106] Maximum Fruits Harvested After at Most K Steps
#

# @lc code=start


class Solution:
    def maxTotalFruits(self, fruits: List[List[int]], startPos: int, k: int) -> int:
        n = len(fruits)

        # return the minimum steps needed to cover [left, right] from startPos
        def step(left, right, startPos):
            l, r = fruits[left][0], fruits[right][0]
            if r <= startPos:
                return startPos - l
            elif startPos <= l:
                return r - startPos
            else:
                return min(abs(startPos - r), abs(startPos - l)) + r - l

        left = right = 0
        curr_sum = 0
        res = 0
        while right < n:
            curr_sum += fruits[right][1]
            while left <= right and step(left, right, startPos) > k:
                curr_sum -= fruits[left][1]
                left += 1
            res = max(res, curr_sum)
            right += 1

        return res


# @lc code=end
