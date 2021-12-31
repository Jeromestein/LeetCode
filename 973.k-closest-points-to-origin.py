#
# @lc app=leetcode id=973 lang=python3
#
# [973] K Closest Points to Origin
#

# @lc code=start

# class Solution:
#     def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
#         # defaultly a max heap
#         heap = []

#         for i in range(len(points)):
#             dis = -(points[i][0]**2+points[i][1]**2)
#             if len(heap) == k:
#                 # guaranteed to be unique
#                 if dis > heap[0][0]:
#                     heapq.heapreplace(heap, (dis, i))
#             else:
#                 heapq.heappush(heap, (dis, i))

#         return [points[i] for (_, i) in heap]

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        # quick_select, since we can return in any order
        """Perform the QuickSelect algorithm on the list"""
        left, right = 0, len(points) - 1
        pivot_index = len(points)
        while pivot_index != k:
            # Repeatedly partition the list
            # while narrowing in on the kth element
            pivot_index = self.partition(points, left, right)
            if pivot_index < k:
                left = pivot_index
            else:
                right = pivot_index - 1

        # Return the first k elements of the partially sorted list
        return points[:k]

    def partition(self, points: List[List[int]], left: int, right: int) -> int:
        """Partition the list around the pivot value"""
        """Choose a pivot element of the list"""
        pivot = points[left + (right - left) // 2]
        pivot_dist = self.squared_distance(pivot)
        while left < right:
            # Iterate through the range and swap elements to make sure
            # that all points closer than the pivot are to the left
            if self.squared_distance(points[left]) >= pivot_dist:
                points[left], points[right] = points[right], points[left]
                right -= 1
            else:
                left += 1

        # Ensure the left pointer is just past the end of
        # the left range then return it as the new pivotIndex
        if self.squared_distance(points[left]) < pivot_dist:
            left += 1
        return left

    def squared_distance(self, point: List[int]) -> int:
        """Calculate and return the squared Euclidean distance."""
        return point[0] ** 2 + point[1] ** 2

# @lc code=end
