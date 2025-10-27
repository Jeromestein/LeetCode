#
# @lc app=leetcode id=1716 lang=python3
#
# [1716] Calculate Money in Leetcode Bank
#


# @lc code=start
class Solution:
    def totalMoney(self, n: int) -> int:
        # 7 ddays a loop
        # 1,2,3,4,5,6,7 = 28 + 7*loop
        res = 0
        loop = n // 7
        last_day = n % 7
        curr = 28
        for i in range(loop):
            res += curr
            curr += 7

        start = loop + 1
        for i in range(last_day):
            res += start
            start += 1

        return res


# @lc code=end
