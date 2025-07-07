#
# @lc app=leetcode id=1865 lang=python3
#
# [1865] Finding Pairs With a Certain Sum
#

# @lc code=start
class FindSumPairs:
    def __init__(self, nums1: List[int], nums2: List[int]):
        self.nums1=nums1
        self.nums2=nums2
        self.map2=Counter(nums2)

    def add(self, index: int, val: int) -> None:
        _nums2, _map2=self.nums2, self.map2

        _map2[_nums2[index]]-=1
        _nums2[index]+=val
        _map2[_nums2[index]]+=1

    def count(self, tot: int) -> int:
        _nums1, _map2=self.nums1, self.map2
        res=0
        for nums in _nums1:
            x=tot-nums
            # check first, it will be faster
            if x in _map2:
                res+=(_map2[x])

        return res
# Your FindSumPairs object will be instantiated and called as such:
# obj = FindSumPairs(nums1, nums2)
# obj.add(index,val)
# param_2 = obj.count(tot)
# @lc code=end

