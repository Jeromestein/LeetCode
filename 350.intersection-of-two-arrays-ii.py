#
# @lc app=leetcode id=350 lang=python3
#
# [350] Intersection of Two Arrays II
#

# @lc code=start

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        count1=Counter(nums1)
        count2=Counter(nums2)
        res=[]
        for num in count1:
            if num in count2:
                length=min(count1[num], count2[num])
                for i in range(length):
                    res.append(num)

        return res

# @lc code=end

