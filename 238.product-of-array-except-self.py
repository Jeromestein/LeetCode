#
# @lc app=leetcode id=238 lang=python3
#
# [238] Product of Array Except Self
#


# @lc code=start
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
        # O(n), O(1)
        n = len(nums)
        answers = [1] * n
        for i in range(1, n):
            answers[i] = answers[i - 1] * nums[i - 1]

        # x=product of nums[i:]
        x = 1
        for i in range(n - 2, -1, -1):
            x *= nums[i + 1]
            answers[i] *= x

        return answers


# @lc code=end
