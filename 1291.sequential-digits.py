#
# @lc app=leetcode id=1291 lang=python3
#
# [1291] Sequential Digits
#

# @lc code=start

class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        sample = "123456789"
        nums = []
        lowLen, highLen = len(str(low)), len(str(high))
        for length in range(lowLen, highLen + 1):
            # from 0 to 10-length
            for start in range(10 - length):
                num = int(sample[start: start + length])
                if low <= num and num <= high:
                    nums.append(num)

        return nums


# @lc code=end
