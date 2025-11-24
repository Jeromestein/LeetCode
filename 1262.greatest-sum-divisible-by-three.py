#
# @lc app=leetcode id=1262 lang=python3
#
# [1262] Greatest Sum Divisible by Three
#


# @lc code=start
class Solution:
    def maxSumDivThree(self, nums: List[int]) -> int:

        # Group nums based on remainder mod 3
        a = [x for x in nums if x % 3 == 0]  # remainder 0
        b = sorted(
            [x for x in nums if x % 3 == 1], reverse=True
        )  # remainder 1, sorted descending
        c = sorted(
            [x for x in nums if x % 3 == 2], reverse=True
        )  # remainder 2, sorted descending

        ans = 0
        lb, lc = len(b), len(c)

        # Try possible counts of elements from B and C.
        # Only need to try {len, len-1, len-2} for each.
        for cntB in [lb - 2, lb - 1, lb]:
            if cntB >= 0:
                for cntC in [lc - 2, lc - 1, lc]:
                    if cntC >= 0 and (cntB - cntC) % 3 == 0:
                        # If counts satisfy mod rule, compute the maximum sum
                        ans = max(ans, sum(b[:cntB]) + sum(c[:cntC]))

        # Add all elements with remainder 0 (since they always fit)
        return ans + sum(a)


# @lc code=end
