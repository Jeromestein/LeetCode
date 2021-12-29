#
# @lc app=leetcode id=875 lang=python3
#
# [875] Koko Eating Bananas
#

# @lc code=start

class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # Initalize the left and right boundaries
        l, r = 1, max(piles)

        while l < r:
            # Get the middle index between left and right boundary indexes.
            # hour_spent stands for the total hour Koko spends.
            mid = (l + r) // 2
            hour_spent = 0

            # Iterate over the piles and calculate hour_spent.
            # We increase the hour_spent by ceil(pile / middle)
            for pile in piles:
                hour_spent += math.ceil(pile / mid)

            # Check if middle is a workable speed, and cut the search space by half.
            if hour_spent <= h:
                r = mid
            else:
                l = mid + 1

        # Once the left and right boundaries coincide, we find the target value,
        # that is, the minimum workable eating speed.
        return l


# @lc code=end
