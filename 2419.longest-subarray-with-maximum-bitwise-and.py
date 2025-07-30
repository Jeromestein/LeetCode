#
# @lc app=leetcode id=2419 lang=python3
#
# [2419] Longest Subarray With Maximum Bitwise AND
#


# @lc code=start
class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        # is this just about the biggest elements?
        max_num = 1
        max_length = 0
        n = len(nums)
        i = 0
        while i < n:
            # i could be 1,2,3,3,2,3,3,3,3,3
            if max_num == nums[i]:
                max_num = nums[i]
                length = 0
                while i < n and nums[i] == max_num:
                    length += 1
                    i += 1
                max_length = max(max_length, length)
            elif max_num < nums[i]:
                max_num = nums[i]
                length = 0
                while i < n and nums[i] == max_num:
                    length += 1
                    i += 1
                max_length = length
            else:
                i += 1

        return max_length


# @lc code=end
