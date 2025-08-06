#
# @lc app=leetcode id=3479 lang=python3
#
# [3479] Fruits Into Baskets III
#


# @lc code=start
class segTree:
    def __init__(self, baskets):
        self.n = len(baskets)
        # 2^(⌈log2(n)⌉+1)
        size = 1 << ((self.n - 1).bit_length() + 1)
        self.seg = [0] * size
        self._build(baskets, 1, 0, self.n - 1)

    def _maintain(self, idx):
        self.seg[idx] = max(self.seg[idx * 2], self.seg[idx * 2 + 1])

    def _build(self, arr, idx, left, right):
        if left == right:
            self.seg[idx] = arr[left]
            return

        m = (left + right) // 2
        self._build(arr, idx * 2, left, m)
        self._build(arr, idx * 2 + 1, m + 1, right)
        self._maintain(idx)

    def find_first_and_update(self, idx, left, right, target):
        if self.seg[idx] < target:
            return -1

        if left == right:
            self.seg[idx] = -1
            return left

        m = (left + right) // 2
        i = self.find_first_and_update(idx * 2, left, m, target)
        if i == -1:
            i = self.find_first_and_update(idx * 2 + 1, m + 1, right, target)
        self._maintain(idx)
        return i


class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        m = len(baskets)
        if m == 0:
            return m

        tree = segTree(baskets)
        cnt = 0

        for f in fruits:
            if tree.find_first_and_update(1, 0, m - 1, f) == -1:
                cnt += 1

        return cnt


# @lc code=end
