#
# @lc app=leetcode id=1018 lang=python3
#
# [1018] Binary Prefix Divisible By 5
#

# @lc code=start


class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        res = []
        curr = 0
        for n in nums:
            curr = curr * 2 + n
            if curr % 5 == 0:
                res.append(True)
            else:
                res.append(False)

        return res


# @lc code=end
