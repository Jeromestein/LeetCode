#
# @lc app=leetcode id=118 lang=python3
#
# [118] Pascal's Triangle
#


# @lc code=start
class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = []
        res.append([1])
        for i in range(1, numRows):
            curr_layer = []
            for j in range(i + 1):
                if j == 0 or j == i:
                    curr_layer.append(1)
                else:
                    curr_layer.append(res[-1][j - 1] + res[-1][j])

            res.append(curr_layer)
        return res


# @lc code=end
