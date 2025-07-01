#
# @lc app=leetcode id=302 lang=python3
#
# [302] Smallest Rectangle Enclosing Black Pixels
#

# @lc code=start
class Solution:
    def minArea(self, image: List[List[str]], x: int, y: int) -> int:
        # use double bs O(logmn) to find boundaries
        # (x2-x1)(y2-y1)
        m,n=len(image), len(image[0])
        def colHasBlack(col):
            for i in range(m):
                if image[i][col]=='1':
                    return True
            return False
        def rowHasBlack(row):
            for j in range(n):
                if image[row][j]=='1':
                    return True
            return False
        # 1. x1
        left, right=0, y
        while left<right:
            mid=(left+right)//2
            if colHasBlack(mid):
                right=mid
            else:
                left=mid+1
        x1=left
        # x2
        left, right=y, n-1
        while left<right:
            mid=(left+right+1)//2
            if colHasBlack(mid):
                left=mid
            else:
                right=mid-1
        x2=left
        # y1
        top, bot = 0, x
        while top<bot:
            mid=(top+bot)//2
            if rowHasBlack(mid):
                bot=mid
            else:
                top=mid+1
        y1=top
        # y2
        top, bot = x, m-1
        while top<bot:
            mid=(top+bot+1)//2
            if rowHasBlack(mid):
                top=mid
            else:
                bot=mid-1
        y2=top

        return (y2-y1+1)*(x2-x1+1)
# @lc code=end
