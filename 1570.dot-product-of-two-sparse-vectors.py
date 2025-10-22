#
# @lc app=leetcode id=1570 lang=python3
#
# [1570] Dot Product of Two Sparse Vectors
#


# @lc code=start
class SparseVector:
    def __init__(self, nums: List[int]):
        self.index_set = set()
        self.vector_map = dict()
        n = len(nums)
        for i in range(n):
            if nums[i] != 0:
                self.index_set.add(i)
                self.vector_map[i] = nums[i]

    # Return the dotProduct of two sparse vectors
    def dotProduct(self, vec: "SparseVector") -> int:
        sum = 0
        for self_i, self_num in self.vector_map.items():
            if self_i in vec.index_set:
                sum += self_num * vec.vector_map[self_i]

        return sum


# Your SparseVector object will be instantiated and called as such:
# v1 = SparseVector(nums1)
# v2 = SparseVector(nums2)
# ans = v1.dotProduct(v2)
# @lc code=end
