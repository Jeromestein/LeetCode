#
# @lc app=leetcode id=134 lang=python3
#
# [134] Gas Station
#

# @lc code=start

class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        #          [1,2,3,4,5]
        #          [3,4,5,1,2]
        # gas-cost:-2-2-2 3 3

        n = len(gas)

        total_tank, curr_tank = 0, 0
        starting_station = 0
        for i in range(n):
            total_tank += gas[i] - cost[i]
            curr_tank += gas[i] - cost[i]
            # If one couldn't get here,
            if curr_tank < 0:
                # Pick up the next station as the starting one.
                starting_station = i + 1
                # Start with an empty tank.
                curr_tank = 0

        return starting_station if total_tank >= 0 else -1


# @lc code=end
