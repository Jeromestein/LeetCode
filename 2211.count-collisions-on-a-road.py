#
# @lc app=leetcode id=2211 lang=python3
#
# [2211] Count Collisions on a Road
#

# @lc code=start


class Solution:
    def countCollisions(self, directions: str) -> int:
        res = 0
        # -1: no car on the left
        # 0: stop car on the left
        # n: n car on the left moving to right
        flag = -1

        for curr in directions:
            if curr == "L":
                if flag >= 0:
                    res += flag + 1
                    flag = 0
            elif curr == "R":
                if flag >= 0:
                    flag += 1
                else:
                    flag = 1
            else:
                # curr==S
                if flag > 0:
                    res += flag
                flag = 0

        return res


# @lc code=end
