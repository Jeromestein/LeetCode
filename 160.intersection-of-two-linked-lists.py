#
# @lc app=leetcode id=160 lang=python3
#
# [160] Intersection of Two Linked Lists
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        ptrA, ptrB=headA, headB
        while ptrA!=ptrB:
            if ptrA:
                ptrA=ptrA.next
            else:
                ptrA=headB
            
            if ptrB:
                ptrB=ptrB.next
            else:
                ptrB=headA

        return ptrA


# @lc code=end

