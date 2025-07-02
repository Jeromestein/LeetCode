#
# @lc app=leetcode id=88 lang=python3
#
# [88] Merge Sorted Array
#

# @lc code=start
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        ptr1, ptr2 = m-1, n-1
        while ptr1>=0 and ptr2 >=0:
            n1,n2=nums1[ptr1], nums2[ptr2]
            if n1>=n2:
                nums1[ptr1+ptr2+1]=n1
                ptr1-=1
            else:
                nums1[ptr1+ptr2+1]=n2
                ptr2-=1

        while ptr2>=0:
            nums1[ptr2]=nums2[ptr2]
            ptr2-=1

        return 
        
# @lc code=end

