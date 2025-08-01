#
# @lc app=leetcode id=480 lang=python3
#
# [480] Sliding Window Median
#


# @lc code=start
class DualHeap:
    def __init__(self, k):
        self.small, self.large = [], []
        self.small_size, self.large_size = 0, 0
        self.delay = defaultdict(int)
        self.k = k

    def prune(self, heap):
        while heap:
            num = -heap[0] if heap is self.small else heap[0]
            if self.delay[num]:
                self.delay[num] -= 1
                if heap is self.small:
                    heapq.heappop(self.small)
                else:
                    heapq.heappop(self.large)
            else:
                break

    def balance(self):
        # samll can have one more than large
        if self.small_size > self.large_size + 1:
            # move top of small -> large
            val = -heapq.heappop(self.small)
            self.small_size -= 1
            heapq.heappush(self.large, val)
            self.large_size += 1
            self.prune(self.small)
        elif self.small_size < self.large_size:
            val = heapq.heappop(self.large)
            self.large_size -= 1
            heapq.heappush(self.small, -val)
            self.small_size += 1
            self.prune(self.large)

    def insert(self, num):
        if not self.small or num <= -self.small[0]:
            heapq.heappush(self.small, -num)
            self.small_size += 1
        else:
            heapq.heappush(self.large, num)
            self.large_size += 1
        self.balance()

    def erase(self, num):
        # lazy deleete: mark and decrement size counter
        self.delay[num] += 1
        if num <= -self.small[0]:
            self.small_size -= 1
            if num == -self.small[0]:
                self.prune(self.small)
        else:
            self.large_size -= 1
            if self.large and num == self.large[0]:
                self.prune(self.large)
        self.balance()

    def get_median(self):
        if self.k % 2 == 1:
            return -self.small[0]
        else:
            return (-self.small[0] + self.large[0]) / 2


class Solution:
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        dh = DualHeap(k)
        res = []
        n = len(nums)
        for i in range(n):
            dh.insert(nums[i])
            if i >= k:
                dh.erase(nums[i - k])
            if i >= k - 1:
                res.append(dh.get_median())

        return res


# @lc code=end
