#
# @lc app=leetcode id=1518 lang=python3
#
# [1518] Water Bottles
#


# @lc code=start
class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        consumed_bottles = 0

        while numBottles >= numExchange:
            # Maximum number of times we can consume numExchange
            # number of bottles using numBottles.
            K = numBottles // numExchange

            consumed_bottles += numExchange * K
            numBottles -= numExchange * K

            numBottles += K

        return consumed_bottles + numBottles


# @lc code=end
