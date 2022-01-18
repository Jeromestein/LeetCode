#
# @lc app=leetcode id=605 lang=python3
#
# [605] Can Place Flowers
#

# @lc code=start

class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        N = len(flowerbed)
        cnt = 0
        for i in range(N):
            if flowerbed[i] == 0 and (i == 0 or flowerbed[i-1] == 0) and (i == N-1 or flowerbed[i+1] == 0):
                flowerbed[i] = 1
                cnt += 1
                print(cnt)
            if cnt >= n:
                return True

        return False
        # @lc code=end
