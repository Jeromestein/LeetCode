#
# @lc app=leetcode id=1353 lang=python3
#
# [1353] Maximum Number of Events That Can Be Attended
#

# @lc code=start

class Solution:
    def maxEvents(self, events: List[List[int]]) -> int:
        # Greedy:
        n=len(events)
        max_day=max(event[1] for event in events)
        events.sort()
        pq=[]
        res,j=0,0
        # each iteration, 
        # we add all the evens start before Day i
        # and pick one with the earliest ending time
        for i in range(1, max_day+1):
            # we add all the evens start before Day i
            while j<n and events[j][0]<=i:
                heapq.heappush(pq, events[j][1])
                j+=1
            # make sure all events in pq is after Day i
            while pq and pq[0]<i:
                heapq.heappop(pq)
            # pick one with the earliest ending time
            if pq:
                heapq.heappop(pq)
                res+=1

        return res
# @lc code=end

