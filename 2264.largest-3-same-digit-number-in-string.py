#
# @lc app=leetcode id=2264 lang=python3
#
# [2264] Largest 3-Same-Digit Number in String
#


# @lc code=start
class Solution:
    def largestGoodInteger(self, num: str) -> str:
        good_intergers = [
            "999",
            "888",
            "777",
            "666",
            "555",
            "444",
            "333",
            "222",
            "111",
            "000",
        ]

        for g in good_intergers:
            if g in num:
                return g

        return ""


# @lc code=end
