#
# @lc app=leetcode id=142 lang=python3
#
# [142] Linked List Cycle II
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = fast = head

        # use slow and fast pointer to find some point in the cycle, p
        while fast and fast.next:
            slow, fast = slow.next, fast.next.next
            if slow == fast:
                break
        else:
            return None  # if not (fast and fast.next): return None
        p = slow

        # each time head and p move 1 step, until they meet at the start of cycle.
        while head != p:
            head, p = head.next, p.next
        return head


# @lc code=end
