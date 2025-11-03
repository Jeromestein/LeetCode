#
# @lc app=leetcode id=3217 lang=python3
#
# [3217] Delete Nodes From Linked List Present in Array
#


# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def modifiedList(
        self, nums: List[int], head: Optional[ListNode]
    ) -> Optional[ListNode]:
        s = set(nums)
        print(s)

        curr = pre = ListNode()
        pre.next = head

        while curr and curr.next:
            if curr.next.val in s:
                curr.next = curr.next.next
            else:
                curr = curr.next

        return pre.next


# @lc code=end
