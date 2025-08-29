#
# @lc app=leetcode id=3021 lang=python3
#
# [3021] Alice and Bob Playing Flower Game
#

# @lc code=start


class Solution:
    def flowerGame(self, n: int, m: int) -> int:
        # for me, it seems like, we just need to make an odd number?
        # pairs=set()
        # # O(mn)
        # for i in range(1,n+1):
        #     for j in range(1,m+1):
        #         if (i+j)%2==1:
        #             pairs.add((i,j))

        # return len(pairs)

        # cal the odds and evens for each lane
        odds_1 = (n + 1) // 2
        odds_2 = (m + 1) // 2
        evens_1 = n // 2
        evens_2 = m // 2

        return odds_1 * evens_2 + evens_1 * odds_2


# @lc code=end
