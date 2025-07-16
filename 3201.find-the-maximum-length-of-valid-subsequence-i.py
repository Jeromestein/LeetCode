#
# @lc app=leetcode id=3201 lang=python3
#
# [3201] Find the Maximum Length of Valid Subsequence I
#

# @lc code=start

class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        res = 0
        for pattern in [[0, 0], [0, 1], [1, 0], [1, 1]]:
            cnt = 0
            for num in nums:
                if num % 2 == pattern[cnt % 2]:
                    cnt += 1
            res = max(res, cnt)
        return res
        
# @lc code=end

