#
# @lc app=leetcode id=2438 lang=python3
#
# [2438] Range Product Queries of Powers
#

# @lc code=start


from typing import List


class Solution:
    def productQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        MOD = 10**9 + 7

        # 1) Decompose n into a list of powers of two that sum to n.
        #    Example: n = 13 (1101b) -> powers = [1, 4, 8]  (in increasing order)
        #    We scan bits from least significant to most significant.
        powers: List[int] = []
        bit_value = 1  # represents 2^k for the current bit position
        while n > 0:
            if n & 1:  # if the current bit is set
                powers.append(bit_value)
            n >>= 1  # move to next bit
            bit_value <<= 1  # next power of two

        m = len(powers)

        # 2) Precompute range products for all subarrays powers[i..j].
        #    range_prod[i][j] stores (powers[i] * ... * powers[j]) % MOD.
        #    Complexity: O(m^2). Here m = number of set bits in the original n,
        #    which is tiny (<= 31 for 32-bit range), so this is perfectly fine.
        range_prod = [[0] * m for _ in range(m)]
        for i in range(m):
            cur = 1
            for j in range(i, m):
                cur = (cur * powers[j]) % MOD
                range_prod[i][j] = cur

        # 3) Answer each query [L, R] in O(1) by a table lookup.
        #    Each query asks for product(powers[L..R]) modulo MOD.
        ans: List[int] = []
        for left, right in queries:
            ans.append(range_prod[left][right])

        return ans


# @lc code=end
