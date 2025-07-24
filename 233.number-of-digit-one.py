#
# @lc app=leetcode id=233 lang=python3
#
# [233] Number of Digit One
#


# @lc code=start
class Solution:
    def countDigitOne(self, n: int) -> int:
        # n< 10^9
        # check every digit
        # 0-9,1
        # 0-99, 10+1*10=20
        # 0-999, 100+20*10=300
        # 0-n..9, n*10^(n-1)

        res = 0
        i = 1
        while i <= n:
            higher = n // (i * 10)
            current = (n // i) % 10
            lower = n % i

            res += higher * i

            if current == 0:
                extra = 0
            elif current == 1:
                extra = lower + 1
            else:
                extra = i

            res += extra
            i *= 10

        return res


# @lc code=end
