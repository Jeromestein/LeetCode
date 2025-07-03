#
# @lc app=leetcode id=349 lang=python3
#
# [349] Intersection of Two Arrays
#

# @lc code=start
class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # n1, n2
        # binary search? nlogn
        # hash map
        count1=Counter(nums1)
        count2=Counter(nums2)
        res=[]
        for num in count1:
            if num in count2:
                res.append(num)

        return res


# @lc code=end

