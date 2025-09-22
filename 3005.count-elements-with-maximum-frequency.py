#
# @lc app=leetcode id=3005 lang=python3
#
# [3005] Count Elements With Maximum Frequency
#


# @lc code=start
class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        cnt = Counter(nums)
        res = 0
        max_freq = 0
        for num, freq in cnt.items():
            if freq > max_freq:
                res = freq
                max_freq = freq
            elif freq == max_freq:
                res += freq
        return res


# @lc code=end
