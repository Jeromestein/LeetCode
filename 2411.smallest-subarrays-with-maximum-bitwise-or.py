#
# @lc app=leetcode id=2411 lang=python3
#
# [2411] Smallest Subarrays With Maximum Bitwise OR
#

# @lc code=start


class Solution:
    def smallestSubarrays(self, nums: List[int]) -> List[int]:
        n = len(nums)
        # <=10^9 ~ 2^30
        pos = [-1] * 30
        res = [1] * n

        for left in range(n - 1, -1, -1):
            right = left
            for bit in range(30):
                if nums[left] & (1 << bit) != 0:
                    pos[bit] = left
                elif pos[bit] != -1:
                    right = max(pos[bit], right)

            res[left] = right - left + 1

        return res


# @lc code=end
