#
# @lc app=leetcode id=141 lang=python3
#
# [141] Linked List Cycle
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if not head:
            return False

        slow, fast= head, head.next
        while slow != fast:
            if fast and fast.next:
                slow=slow.next
                fast=fast.next.next
            else:
                return False
        
        return True  
# @lc code=end

