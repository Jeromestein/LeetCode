#
# @lc app=leetcode id=120 lang=python3
#
# [120] Triangle
#

# @lc code=start


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        # Start with the last row as the "base case"
        # This row represents the minimum path sums for the bottom layer
        below_row = triangle[-1]
        n = len(triangle)

        # Process rows from the second-to-last row up to the top
        for row in reversed(range(n - 1)):
            curr_row = []
            # For each element in the current row
            for col in range(row + 1):
                # Choose the smaller path sum from the two possible children
                smallest_below = min(below_row[col], below_row[col + 1])
                # Add the current value to the chosen minimum path
                curr_row.append(triangle[row][col] + smallest_below)
            # Update the "below_row" to be the newly computed current row
            below_row = curr_row

        # The top element now contains the minimum path sum
        return below_row[0]


# @lc code=end
