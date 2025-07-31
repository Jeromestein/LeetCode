#
# @lc app=leetcode id=898 lang=python3
#
# [898] Bitwise ORs of Subarrays
#

# @lc code=start


class Solution:
    def subarrayBitwiseORs(self, arr: List[int]) -> int:
        n = len(arr)
        # brutal : O(n^2)
        res = set()
        prev_ors = set()
        for num in arr:
            curr_ors = set()
            curr_ors.add(num)
            for s in prev_ors:
                curr_ors.add(s | num)
            res.update(curr_ors)
            prev_ors = curr_ors

        return len(res)


# @lc code=end
