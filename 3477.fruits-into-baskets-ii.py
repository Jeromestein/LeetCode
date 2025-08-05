#
# @lc app=leetcode id=3477 lang=python3
#
# [3477] Fruits Into Baskets II
#

# @lc code=start


class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        n, m = len(fruits), len(baskets)
        res = 0
        for i in range(n):
            unplaced = True
            for j in range(m):
                # 1 <= fruits[i], baskets[i] <= 1000
                if baskets[j] >= fruits[i]:
                    baskets[j] = 0
                    unplaced = False
                    break
            res += 1 if unplaced == True else 0

        return res


# @lc code=end
