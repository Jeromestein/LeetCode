#
# @lc app=leetcode id=3461 lang=python3
#
# [3461] Check If Digits Are Equal in String After Operations I
#

# @lc code=start


class Solution:
    def hasSameDigits(self, s: str) -> bool:
        nums = []
        for c in s:
            nums.append(int(c))

        n = len(nums)
        while n > 2:
            for i in range(n - 1):
                nums[i] = (nums[i] + nums[i + 1]) % 10

            n -= 1

        return nums[0] == nums[1]


# @lc code=end
