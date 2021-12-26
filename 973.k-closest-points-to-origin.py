#
# @lc app=leetcode id=973 lang=python3
#
# [973] K Closest Points to Origin
#

# @lc code=start
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        # defaultly a max heap
        heap = []

        for i in range(len(points)):
            dis = -(points[i][0]**2+points[i][1]**2)
            if len(heap) == k:
                # guaranteed to be unique
                if dis > heap[0][0]:
                    heapq.heapreplace(heap, (dis, i))
            else:
                heapq.heappush(heap, (dis, i))

        return [points[i] for (_, i) in heap]

# @lc code=end
