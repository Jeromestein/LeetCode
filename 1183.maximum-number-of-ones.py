#
# @lc app=leetcode id=1183 lang=python3
#
# [1183] Maximum Number of Ones
#

# @lc code=start


class Solution:
    def maximumNumberOfOnes(
        self, width: int, height: int, sideLength: int, maxOnes: int
    ) -> int:
        # 'count' will store how many times each cell (r, c)
        # in the repeating pattern is covered by a sideLength × sideLength submatrix.
        count = []

        # Iterate over every possible position (r, c)
        # inside one pattern tile (of size sideLength × sideLength)
        for r in range(sideLength):
            for c in range(sideLength):
                # The key idea:
                # For a given cell (r, c), we compute how many times
                # this cell appears inside all possible sideLength × sideLength windows
                # when the pattern of size (height × width) is tiled infinitely.

                # Compute how many times the cell contributes vertically and horizontally.
                # (width - c - 1) is how far the column is from the right edge.
                # Dividing by sideLength gives how many complete blocks fit after it,
                # and adding 1 counts the current block.
                # Same logic for the vertical direction.
                #
                # In other words:
                # num = (# of pattern repetitions along x) * (# of repetitions along y)
                #
                # Example:
                # - If width = 8, sideLength = 5, c = 1
                #   → (width - c - 1) // sideLength = 1 → (1 + 1) = 2 columns contribute
                # - So this cell appears twice horizontally across all windows.
                num = (1 + (width - c - 1) // sideLength) * (
                    1 + (height - r - 1) // sideLength
                )

                # Append this cell's appearance count
                count.append(num)

        # Sort all cells by their contribution frequency (descending)
        count.sort(reverse=True)

        # We can only place 'maxOnes' number of ones in the base pattern.
        # To maximize the total number of ones in all sideLength × sideLength windows,
        # we pick the 'maxOnes' cells that appear the most frequently.
        return sum(count[:maxOnes])


# @lc code=end
