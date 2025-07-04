#
# @lc app=leetcode id=3307 lang=python3
#
# [3307] Find the K-th Character in String Game II
#

# @lc code=start
class Solution:
    def kthCharacter(self, k: int, operations: List[int]) -> str:
        # k = 2^i+j
        # find i and j
        # every k is changed from the original 'a'
        ans=0
        while k!=1:
            # k = 2^i+j, 1 <= operations.length <= 100
            i=k.bit_length()-1
            if (1<<i)==k:
                i-=1
            k-=1<<i
            ans += operations[i]

        return chr(ord('a')+ans%26)
    
    
# @lc code=end

