#
# @lc app=leetcode id=1317 lang=python3
#
# [1317] Convert Integer to the Sum of Two No-Zero Integers
#


# @lc code=start
class Solution:
    def getNoZeroIntegers(self, n: int) -> List[int]:
        for x in range(1, n):
            y = n - x
            if "0" not in str(x) + str(y):
                return [x, y]

        return


# @lc code=end
