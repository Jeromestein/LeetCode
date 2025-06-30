#
# @lc app=leetcode id=594 lang=python3
#
# [594] Longest Harmonious Subsequence
#

# @lc code=start

# class Solution:
#     def findLHS(self, nums):
#         nums.sort()
#         j = 0
#         maxLength = 0

#         for i in range(len(nums)):
#             while nums[i] - nums[j] > 1:
#                 j += 1
#             if nums[i] - nums[j] == 1:
#                 maxLength = max(maxLength, i - j + 1)
#         return maxLength

class Solution:
    def findLHS(self, nums):
        freq_map = Counter(nums)
        max_length = 0

        for num in freq_map:
            if num + 1 in freq_map:
                current_length = freq_map[num] + freq_map[num + 1]
                max_length = max(max_length, current_length)

        return max_length

# @lc code=end

