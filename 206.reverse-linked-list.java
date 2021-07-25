/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            // if length of list < 2, return directly
            return head;
        }

        // get old tail
        ListNode oldTail = head;
        ListNode p = head;
        while (p != null) {
            oldTail = p;
            p = p.next;
        }

        ListNode oldTailNext = oldTail.next;
        ListNode first = head;
        while (oldTailNext != oldTail) {
            ListNode firstNext = first.next;

            first.next = oldTailNext;
            oldTailNext = first;

            first = firstNext;
        }

        return oldTail;
    }
}
// @lc code=end
