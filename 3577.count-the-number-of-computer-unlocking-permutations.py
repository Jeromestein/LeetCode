#
# @lc app=leetcode id=3577 lang=python3
#
# [3577] Count the Number of Computer Unlocking Permutations
#


# @lc code=start
class Solution:
    def countPermutations(self, complexity: List[int]) -> int:
        MOD = 10**9 + 7
        n = len(complexity)

        for i in range(1, n):
            if complexity[0] >= complexity[i]:
                return 0

        return math.perm(n - 1, n - 1) % MOD


# @lc code=end
