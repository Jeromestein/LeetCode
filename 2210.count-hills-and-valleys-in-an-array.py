#
# @lc app=leetcode id=2210 lang=python3
#
# [2210] Count Hills and Valleys in an Array
#

# @lc code=start


class Solution:
    def countHillValley(self, nums: List[int]) -> int:
        n = len(nums)
        count, left = 0, 0
        for i in range(1, n - 1):
            if nums[i] != nums[i + 1]:
                if (nums[i] > nums[left] and nums[i] > nums[i + 1]) or (
                    nums[i] < nums[left] and nums[i] < nums[i + 1]
                ):
                    count += 1
                left = i

        return count


# @lc code=end
