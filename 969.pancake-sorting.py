#
# @lc app=leetcode id=969 lang=python3
#
# [969] Pancake Sorting
#

# @lc code=start
class Solution:
    def pancakeSort(self, arr: List[int]) -> List[int]:
        n=len(arr)
        res=[]

        for i in range(n,0,-1):
            idx=arr.index(i)
            arr[0:idx+1]=reversed(arr[0:idx+1])
            res.append(idx+1)
            arr[0:i]=reversed(arr[0:i])
            res.append(i)

        return res


# @lc code=end

