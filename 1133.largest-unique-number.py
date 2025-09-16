#
# @lc app=leetcode id=1133 lang=python3
#
# [1133] Largest Unique Number
#


# @lc code=start
class Solution:
    def largestUniqueNumber(self, nums: List[int]) -> int:
        # hashmap
        cnt = Counter(nums)
        max_unique = -1
        for i, freq in cnt.items():
            if freq == 1:
                max_unique = max(max_unique, i)

        return max_unique


# @lc code=end
