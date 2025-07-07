#
# @lc app=leetcode id=1394 lang=python3
#
# [1394] Find Lucky Integer in an Array
#

# @lc code=start
class Solution:
    def findLucky(self, arr: List[int]) -> int:
        cnt=Counter(arr)
        res=-1
        for num in cnt:
            if res<=num and num==cnt[num]:
                res=num

        return res

# @lc code=end

