#
# @lc app=leetcode id=3289 lang=python3
#
# [3289] The Two Sneaky Numbers of Digitville
#


# @lc code=start
class Solution:
    def getSneakyNumbers(self, nums: List[int]) -> List[int]:
        # There are (n + 2) numbers in nums, where 0..n should appear once,
        # but two of them are duplicated (the "sneaky numbers").
        n = len(nums) - 2

        # Step 1: XOR all numbers in nums to get y
        y = 0
        for x in nums:
            y ^= x  # XOR all elements in the input array

        # Step 2: XOR all numbers from 0 to n
        for i in range(n):
            y ^= i  # XOR expected unique range [0..n-1]

        # After these two loops:
        # y = duplicate1 ^ duplicate2
        # because all other numbers (that appear once) cancel out (a ^ a = 0)

        # Step 3: Find the rightmost set bit (lowest differing bit)
        lowBit = y & -y
        # This bit distinguishes the two sneaky numbers (they differ here)

        x1 = x2 = 0

        # Step 4: Divide nums into two groups based on lowBit
        # One group has this bit = 1, the other has it = 0
        # Then XOR within each group separately.
        for x in nums:
            if x & lowBit:
                x1 ^= x
            else:
                x2 ^= x

        # Step 5: Do the same partition for 0..n (the normal range)
        # to remove all single occurrences (cancel them out)
        for i in range(n):
            if i & lowBit:
                x1 ^= i
            else:
                x2 ^= i

        # Step 6: Now x1 and x2 are the two duplicate (sneaky) numbers
        return [x1, x2]


# @lc code=end
