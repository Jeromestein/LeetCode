#
# @lc app=leetcode id=38 lang=python3
#
# [38] Count and Say
#

# @lc code=start


class Solution:
    def countAndSay(self, n: int) -> str:
        # The sequence starts with "1"
        current_string = "1"

        # Repeat the process (n - 1) times to generate the nth term
        for _ in range(n - 1):
            next_string = ""  # This will hold the next term in the sequence
            j = 0
            k = 0

            # Traverse the current_string to "read" it and generate the next one
            while j < len(current_string):
                # Move k forward while the same digit repeats
                while (
                    k < len(current_string) and current_string[k] == current_string[j]
                ):
                    k += 1

                # Now, from j to k-1 is a block of identical digits
                # The length of this block is (k - j)
                # So we "say" (k - j) followed by the digit itself
                next_string += str(k - j) + current_string[j]

                # Move j to the next new digit
                j = k

            # Update the current_string for the next iteration
            current_string = next_string

        # After generating all terms, return the nth string
        return current_string


# @lc code=end
