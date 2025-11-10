#
# @lc app=leetcode id=3321 lang=python3
#
# [3321] Find X-Sum of All K-Long Subarrays II
#


# @lc code=start
class XSum:
    def __init__(self, x):
        self.X = x
        self.result = 0
        self.large, self.small = SortedList(), SortedList()
        self.freq = defaultdict(int)

    def insert(self, num):
        if self.freq[num] > 0:
            self.internal_remove((self.freq[num], num))
        self.freq[num] += 1
        self.internal_insert((self.freq[num], num))

    def remove(self, num):
        self.internal_remove((self.freq[num], num))
        self.freq[num] -= 1
        if self.freq[num] > 0:
            self.internal_insert((self.freq[num], num))

    def get(self):
        return self.result

    def internal_insert(self, p):
        if len(self.large) < self.X or p > self.large[0]:
            self.large.add(p)
            self.result += p[0] * p[1]

            if len(self.large) > self.X:
                to_remove = self.large[0]
                self.result -= to_remove[0] * to_remove[1]
                self.large.remove(to_remove)
                self.small.add(to_remove)
        else:
            self.small.add(p)

    def internal_remove(self, p):
        if p >= self.large[0]:
            self.result -= p[0] * p[1]
            self.large.remove(p)
            if self.small:
                to_add = self.small[-1]
                self.result += to_add[0] * to_add[1]
                self.small.remove(to_add)
                self.large.add(to_add)
        else:
            self.small.remove(p)


class Solution:
    def findXSum(self, nums, k, x):
        x_sum = XSum(x)
        ans = []

        for i in range(len(nums)):
            x_sum.insert(nums[i])
            if i >= k:
                x_sum.remove(nums[i - k])
            if i >= k - 1:
                ans.append(x_sum.get())

        return ans


# @lc code=end
