#
# @lc app=leetcode id=904 lang=python3
#
# [904] Fruit Into Baskets
#

# @lc code=start


class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        n = len(fruits)
        basket = {}
        left = right = res = 0
        for right in range(n):
            basket[fruits[right]] = basket.get(fruits[right], 0) + 1
            while len(basket) > 2:
                basket[fruits[left]] -= 1
                if basket[fruits[left]] == 0:
                    del basket[fruits[left]]
                left += 1

            res = max(res, right - left + 1)
        return res


# @lc code=end
