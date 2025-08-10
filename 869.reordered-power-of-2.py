#
# @lc app=leetcode id=869 lang=python3
#
# [869] Reordered Power of 2
#


# @lc code=start
class Solution:
    def reorderedPowerOf2(self, N: int) -> bool:
        # Return a canonical "signature" of a number's digits
        # e.g. 128 -> ('1','2','8'), 281 -> ('1','2','8')
        def digit_signature(x: int) -> tuple[str, ...]:
            return tuple(sorted(str(x)))

        target_sig = digit_signature(N)
        target_len = len(str(N))

        # Only check powers of two that have the same number of digits
        # 2^0..2^30 covers up to 1,073,741,824 (> 1e9), enough for constraints
        for b in range(31):
            val = 1 << b
            if len(str(val)) != target_len:
                continue
            if digit_signature(val) == target_sig:
                return True

        return False


# @lc code=end
