/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 1. get pre head
        ListNode preLeft = new ListNode(0, head);
        ListNode oldHead = head, oldTail = head;
        int i = 1;
        while (i < left) {
            preLeft = oldHead;

            oldHead = oldHead.next;
            oldTail = oldHead;
            i++;
        }
        while (i < right) {
            oldTail = oldTail.next;
            i++;
        }

        preLeft.next = myReverseLinkedList(oldHead, oldTail)[0];

        return left == 1 ? oldTail : head;
    }

    public ListNode[] myReverseLinkedList(ListNode oldHead, ListNode oldTail) {
        ListNode oldTailNext = oldTail.next;
        ListNode first = oldHead;

        while (oldTailNext != oldTail) {
            ListNode firstNext = first.next;

            first.next = oldTailNext;
            oldTailNext = first;

            first = firstNext;
        }

        return new ListNode[] { oldTail, oldHead };
    }
}
// @lc code=end
