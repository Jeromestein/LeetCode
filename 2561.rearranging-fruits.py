#
# @lc app=leetcode id=2561 lang=python3
#
# [2561] Rearranging Fruits
#

# @lc code=start


from collections import Counter
from typing import List


class Solution:
    def minCost(self, basket1: List[int], basket2: List[int]) -> int:
        """
        Make the two baskets have the same multiset by swapping elements.
        Each mismatch can be fixed either directly (cost = value) or indirectly
        via the global minimum element (cost = 2 * global_min). Return the minimum total cost.
        If it's impossible (some value has odd total count), return -1.
        """
        imbalance = Counter()  # difference in counts: basket1 minus basket2
        global_min = float("inf")  # smallest element seen across both baskets

        # Count items in first basket and track global minimum
        for val in basket1:
            imbalance[val] += 1
            if val < global_min:
                global_min = val

        # Subtract counts from second basket and update global minimum
        for val in basket2:
            imbalance[val] -= 1
            if val < global_min:
                global_min = val

        # Build list of surplus values that need to be swapped (only one side's excess)
        surplus = []
        for value, diff in imbalance.items():
            if diff % 2 != 0:
                # If any value has odd total imbalance, impossible to pair
                return -1
            need = abs(diff) // 2
            if need:
                surplus.extend([value] * need)

        if not surplus:
            # Already balanced
            return 0

        surplus.sort()  # sort to greedily pick smallest values to fix first

        half = len(surplus) // 2  # each actual swap fixes two surplus entries
        total_cost = 0
        for x in surplus[:half]:
            # For each required move, choose the cheaper: direct swap (x) or via global min (2*global_min)
            total_cost += min(x, 2 * global_min)

        return total_cost


# @lc code=end
