#
# @lc app=leetcode id=2081 lang=python3
#
# [2081] Sum of k-Mirror Numbers
#

# @lc code=start
class Solution:
    def kMirror(self, k: int, n: int) -> int:
        def isPalindrome(num: int) -> bool:
            digit = list()
            while num:
                digit.append(num % k)
                num //= k
            return digit == digit[::-1]
        
        left = 1
        count = 0
        res = 0

        while count < n:
            right = left * 10
            # op = 0 indicates enumerating odd-length palindromes
            # op = 1 indicates enumerating even-length palindromes
            for op in [0, 1]:
                # enumerate 1
                for i in range(left, right):
                    if count == n:
                        break

                    combined = i
                    if op ==0:
                        num = i // 10
                    else:
                        num = i

                    while num:
                        combined = combined * 10 + num % 10
                        num //= 10
                    if isPalindrome(combined):
                        count += 1
                        res += combined
            left = right

        return res    
# @lc code=end

