#
# @lc app=leetcode id=1925 lang=python3
#
# [1925] Count Square Sum Triples
#


# @lc code=start
class Solution:
    def countTriples(self, n: int) -> int:
        res = 0
        for a in range(1, n - 1):
            for b in range(a, n):
                c = int((a**2 + b**2) ** 0.5)
                if c <= n and a**2 + b**2 == c**2:
                    if a != b:
                        res += 2
                    else:
                        res += 1

        return res


# @lc code=end
