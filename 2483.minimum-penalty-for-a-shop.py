#
# @lc app=leetcode id=2483 lang=python3
#
# [2483] Minimum Penalty for a Shop
#

# @lc code=start


class Solution:
    def bestClosingTime(self, customers: str) -> int:
        n = len(customers)
        min_p = p = 0
        min_p_idx = 0

        for i in range(n):
            if customers[i] == "Y":
                p -= 1
            else:
                p += 1

            if min_p > p:
                min_p = p
                min_p_idx = i + 1  # [1,n+1]

        return min_p_idx


# @lc code=end
