#
# @lc app=leetcode id=29 lang=python3
#
# [29] Divide Two Integers
#

# @lc code=start


class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        # Handle overflow case explicitly (LeetCode edge case)
        if dividend == -(2**31) and divisor == -1:
            return 2**31 - 1  # clamp to 32-bit signed integer max

        # Determine the sign of the result
        # XOR: exclusive OR
        negative = (dividend < 0) ^ (divisor < 0)

        # Work with positive values for simplicity
        dividend, divisor = abs(dividend), abs(divisor)
        quotient = 0

        # Subtract divisor in powers of two
        while dividend >= divisor:
            temp, multiple = divisor, 1
            # Keep doubling divisor until it exceeds dividend
            while dividend >= (temp << 1):
                temp <<= 1
                multiple <<= 1

            # Subtract the largest doubled divisor found
            dividend -= temp
            quotient += multiple

        # Apply the sign
        if negative:
            quotient = -quotient

        # Clamp result to 32-bit signed integer range
        return max(-(2**31), min(quotient, 2**31 - 1))


# @lc code=end
